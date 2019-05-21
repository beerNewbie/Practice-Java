## lock体系

- [ ] JDK1.5之后增加java.util.concurrent.locks提供了与内建锁完全不同的实现多线程共享资源体访问机制。**失去了内建锁隐式的加锁与解锁过程，增加了可中断的获取锁、超时获取锁以及共享锁等内建锁不具备的特性。**
- [ ] lock锁的标准使用形式：

```java 
 Lock lock = new ReentrantLock();
 try {
     lock.lock();
     //同步块
 }finally {
     lock.unlock();
 }
```

#### 4.1 lock接口API

##### (1). void lock();//获取锁

##### (2). void lockInterruptibly() throws InterruptedException;//获取锁的过程能够响应中断（lock独有）

##### (3). boolean tryLock();//获取锁返回true，否则返回false。可以响应中断。

##### (4). boolean tryLock(long time,TimeUntil until);//在（3）的基础上增加了超时等待机制，规定时间内未获取到锁，线程直接返回（lock独有）

##### (5). void unlock();//解锁

#### 4.2 AbstractQueuedSynchronized(同步器),lock体系中最核心的存在

- [ ] **同步器是用来构建锁与其他同步组建的基础框架。他的实现主要依赖一个int型成员变量来表示同步状态以及通过一个FIFO队列构成同步队列。**
- [ ] **要使用AQS，推荐使用静态内部类继承AQS，覆写AOS中的protected用来改变同步状态的方法，其他方法主要实现排队与阻塞机制。状态更新使用getState()、setState()、compareAndSetState().**

```java
 package per.hbc.testLock.testMyLock;
 
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//实现自己的锁
class MyLock implements Lock {
    private Syn sync = new Syn();
    static class Syn extends AbstractQueuedSynchronizer {
        //规定同步状态为1
        @Override
        protected boolean tryAcquire(int arg) {
            if (arg != 1) {
                throw new RuntimeException("Illegal arg");
            }
            if (compareAndSetState(0, 1)) {
                //当前线程成功获取到锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
    //***************Lock接口方法*********************
    @Override
    public void lock() {
        sync.acquire(1);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, time);
    }
    @Override
    public void unlock() {
        sync.release(1);
    }
    @Override
    public Condition newCondition() {
        return null;
    }
}

class MyThread implements Runnable {
    Lock lock = new MyLock();
    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
/**
 * 锁住了 
 * Debug:
 * "Attach Listener"@555: RUNNING
 * "DestroyJavaVM"@543 in group "main": RUNNING
 * "Finalizer"@557: WAIT
 * "Reference Handler"@558: WAIT
 * "Signal Dispatcher"@556: RUNNING
 * "Thread-2"@546 in group "main": SLEEPING
 * "Thread-3"@547 in group "main": WAIT
 * "Thread-4"@548 in group "main": WAIT
 * "Thread-5"@550 in group "main": WAIT
 * "Thread-6"@551 in group "main": WAIT
 * "Thread-7"@552 in group "main": WAIT
 * "Thread-8"@553 in group "main": WAIT
 * "Thread-9"@554 in group "main": WAIT
 */

```

- [ ] **lock面向使用者，定义了使用者与锁交互的接口，隐藏了实现细节；AQS面向锁的实现者，简化了锁的实现方式，屏蔽同步状态的管理、线程排队、线程等待与唤醒等底层操作。**

#### 4.2 AQS提供的模板方法

##### 4.2.1 独占锁

###### (1). void acquire(int arg):独占式获取同步状态，如果获取失败则将当前线程插入同步队列进行等待。

###### (2). void acquireInterruptibly(int arg):在（1）的基础上增加响应中断

###### (3). boolean tryAcquireNanos(int arg,long nanosTimeOut):在（2）的基础上增加超时等待，在规定时间内未获取到同步状态返回false

###### (4). boolean tryAcquire(int arg):获取状态成功返回true，否则返回false

###### (5). boolean release(int arg):释放同步状态，该方法会唤醒同步队列的下一个节点

##### 4.2.1 共享锁

##### AQS中的同步队列是一个带有头尾指针的双向链表，节点的组成为：

###### Node prev;

###### Node next;

###### Thread thread;

###### 将线程封装为Node节点后进行入队与出对处理；

#### 4.3 深入理解AQS

##### 4.3.1 独占锁获取--**acquire(int arg)**

```java
public final void acquire(int arg) {
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg)) {
            selfInterrupt();
    }
}


//exclusive :独享，独占
//mode :模式
//indicate :表明指示
//marker :标记
```

- 1.**tryAcquire再次使用CAS尝试获取同步状态，若成功方法直接返回，当前线程为持有锁线程。若再次尝试失败，调用addWaiter()**
- 2.**addWaiter() 源码--将当前线程封装为Node节点后尾插入同步队列中**

```java
private Node addWaiter(Node mode) {
//将当前线程以指定模式封装为Node节点
    Node node = new Node(Thread.currentThread(), mode);
    //Try the fast path of enq(询问); backup to full enq on failure
//拿到当前同步队列的尾节点
    Node pred = tail;
    if (pred != null) {
        node.pred = pred;
        //将当前节点使用CAS尾插入同步队列
        if (compareAndSetTail(pred, node)) {
            pred.next = node;
            return node;
        }
    }
    //当前队列为空或CAS尾插失败时
    enq(node);
    return node;
}
```

> enq()-- 当同步队列为空时完成同步队列初始化操作；以及不断CAS将当前节点尾插入同步队列中

```java
    private Node enq(final Node node) {
        //死循环--不断自旋
        for(;;) {
            //拿到尾节点
            Node t = tail;
            //当前队列为空
            if (t == null) {
                //完成队列的初始化操作lazy-load(懒加载，节省空间)
                if (compareAndSetHead(new Node()))//带有头结点的链表，头结点不放数据，只是作为一个起始位置，因此new一个
                    tail = head;
            }else {
                node.pred = t;
                //不断将当前节点使用CAS尾插到同步队列中直到成功为止
                if (compareAndSet(t, node) {
                    t.next = node;
                    return t;
                }
            }
        }
    }
```

- 3.节点从同步队列获取同步状态的条件：**只有当前驱节点为头结点时，线程才有机会获取同步状态：if(p == head && tryAcquire(arg))**

```java
acquireQueued()--
    fianl boolean acqurieQueued(fianl Node node, int arg) {
        //设置失败状态，初始化为true
        boolean failed = true;
        try {
            //设置中断状态，默认为false
            boolean interrupted = false;
            //不断自旋
            for (;;) {
                //拿到当前节点的前驱节点
                fianl Node p = node.predecessor();
                //**********important***********
                //当前节点前驱节点为头结点并且再次获取同步状态成功
                if (p == head && tryAcqurie(arg)) {
                //**********important***********
                    //将当前节点置为头结点
                    setHead(node);
                    //将前驱节点出队
                    p.next = null;//help GC
                    failed = false;
                    return interrupted;.
                }
                if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt())
                    interrupted = true;
            }
        }fianlly {
            if (failed) 
                //将当前节点置为取消状态，node.waitStutas = 1;(取消状态为1，初始状态为0)
                cancelAquire(node);
            
        }
    }
```

> 当线程获取同步状态失败时，首先调用shouldParkAfterFailedAcquire(Node pred, Node node):**尝试将前驱节点状态改为Node.SIGNAL,表示此时当前节点应该被阻塞**

```java
private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
    //获取前驱节点状态
    int ws = pred.waitStatus;
    if (ws == Node.SIGNAL)//Node.SIGNAL为-1，就是前驱节点的状态是-1，当前节点的后继节点处于等待状态
        //表示应该将当前节点阻塞
        return true;
    //前驱节点被取消
    if (ws > 0) {
        //一直向前找到节点不是取消状态的节点
        do {
            node.prev = pred = pred.prev;
        }while (pred.waitStatus > 0);
        pred.next = node;
    }else {
        //将前驱节点状态置为SIGNAL：-1
        compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
    }
    return false;
}
```

##### 4.3.2 独占锁的释放-release()

```java
public final boolean release(int arg) {
    if (tryRelease(arg)) {
        //获取当前同步队列的头结点
        Node h = head;
        if (h != null && h.waitStatus != 0)//不是处于初始化
            unparkSuccessor(h);//successor:继承者
        return true;
    }
    return false;
}

```

- **unparkSuccessor():唤醒距离头结点最近的一个非空节点**

```java
private void unparkSuccessor(Node node) {
    int ws = node.waitStatus;
    if (ws < 0)
        compareAndSetWaitStatus(node, ws, 0);
    Node s = node.next;
    if (s == null || s.aitStatus > 0) {
        s = null;
        //***********important***************
        //当头结点的下一个节点为空时，从同步队列的尾部开始一直向前找到距离头结点最近的一个非空节点
        for (Node t = tail; t != null && t != node; t = t.prev)
            if (t.waitStatus <= 0)
                s = t;
        //***********important***************
    }
    if (s != null) {
        LockSupport.unpark(s.thread);
    }
}
```

#### 4.4独占式锁特性学习

##### 4.4.1 可中断获取锁

- [ ] **void lockInterruptibly() throws InterruptedException;**最终会调用AQS中**acquireInterruptibly(int arg)**模板方法

```java
 public final void acquireInterruptibly(int arg)
            throws InterruptedException {
     //增加了对中断状态的判断，若检测线程中断状态改变，抛出异常后方法直接退出
        if (Thread.interrupted())
            throw new InterruptedException();
        if (!tryAcquire(arg))
            doAcquireInterruptibly(arg);
    }
```

> doAcquireInterruptibly():

```java
private void doAcquireInterruptibly(int arg)
        throws InterruptedException {
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try {
            for (;;) {
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return;
                }
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    //线程被阻塞时，若检测到中断，中断异常抛出后 退出
                    throw new InterruptedException();
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }
```

##### 4.4.2 超时等待获取锁-在中断获取锁的基础上增加超时等待功能

- [ ] ```java 
  boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
  ```

- [ ] 该方法本质调用AQS的模板方法**tryAcquireNanos(int arg, long nanosTimeout)**

```java
public final boolean tryAcquireNanos(int arg, long nanosTimeout)
            throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        return tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout);
    }
```

> doAcquireNanos()

```java
 private boolean doAcquireNanos(int arg, long nanosTimeout)
            throws InterruptedException {
     //传入时间小于0，方法直接退出，线程获取失败
        if (nanosTimeout <= 0L)
            return false;
     //根据超时时间计算出截止时间
        final long deadline = System.nanoTime() + nanosTimeout;
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try {
            for (;;) {
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return true;
                }
                //再次计算当前截止时间-当前时间
                nanosTimeout = deadline - System.nanoTime();
                //如果小于0，已超时，程直接退出
                if (nanosTimeout <= 0L)
                    return false;
                if (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold)
                    //在超时时间内仍未被唤醒，线程退出 
                    LockSupport.parkNanos(this, nanosTimeout);
                if (Thread.interrupted())
                    throw new InterruptedException();
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }
```

#### 4.5 ReentrantLock（Lock中使用最多）-可重入锁

- [ ] **内建锁隐式支持重入性，synchronized通过获取自增，释放自减的方式实现重入。**

##### 4.5.1 重入性实现原理

###### 4.5.1.1 重入性锁的特点

- **线程获取锁的时候，如果已经获取锁的线程是当前线程直接再次获取**
- **由于锁会被获取N次，因此锁只有被释放N次后，才被真正释放成功**

```java
final boolean nonfairTryAcquire(int acquires) {
    	//拿到当前线程
            final Thread current = Thread.currentThread();
    	//获取当前同步状态
            int c = getState();
            if (c == 0) {
                //当前同步状态还未被获取
                //当前线程使用CAS尝试获取同步状态
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
    	//此时同步状态不为0，表示已有线程获取到同步状态
    	//判断持有线程是否是当前线程
            else if (current == getExclusiveOwnerThread()) {
                //若是当前线程，同步状态再次+1
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                //将再次+1后的状态写回内存
                setState(nextc);
                return true;
            }
    	//不是当前线程返回false
            return false;
        }
```

##### 4.5.2 公平锁与非公平锁

- [ ] **公平锁：锁的获取顺序一定满足时间上的顺序，等待时间最长的线程一定最先获取到锁**
- [ ] **ReentrantLock默认使用非公平锁**
- [ ] 非公平锁 -- nonFairSync

```java
final void lock() {
    //不在队列中的线程可能直接获取到锁
    if (compareAndSetState(0, 1))
    	setExclusiveOwnerThread(Thread.currentThread());
    else
    	acquire(1);
}
```

- [ ] 公平锁 -- FairSync

```java
final void lock() {
//少了一次CAS过程
	acquire(1);
}
//----------------------------
protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
    		//公平锁只增加了!hasQueuedPredecessors()
    		//当同步队列中存在非空节点，当前线程直接封装为Node节点排队
            if (c == 0) {
                if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }
```

- [ ] 公平锁与非公平锁对比：
  - **公平锁保证每次获取锁均为同步队列的第一个节点，保证了请求资源时间上的绝对顺序，但是效率较低，需要频繁的进行上下文切换（即频繁的阻塞唤醒）**
  - **非公平锁会降低性能开销，降低一定的上下文切换，但是可能导致其他线程永远无法获取到锁，造成线程“饥饿”现象。**
  - **通常来讲，没有特定的公平性要求尽量使用非公平锁（ReentrantLock默认选择）**

#### 4.6 ReentrantReadWriteLock

##### 4.6.1 读写者模型：

> **读写锁允许同一时刻被多个读线程访问，但是在写线程访问时，所有的读线程以及其他写线程均会被阻塞。**

##### 4.6.2 写锁详解 - 独占锁

- [ ] 写锁的获取--**tryAcquire(int acquires)**

```java
 protected final boolean tryAcquire(int acquires) {
            /*
             * Walkthrough:
             * 1. If read count nonzero or write count nonzero
             *    and owner is a different thread, fail.
             * 2. If count would saturate, fail. (This can only
             *    happen if count is already nonzero.)
             * 3. Otherwise, this thread is eligible for lock if
             *    it is either a reentrant acquire or
             *    queue policy allows it. If so, update state
             *    and set owner.
             */
            Thread current = Thread.currentThread();
     		//获取读写锁状态
            int c = getState();
     		//获取独占式锁状态（即写锁状态）
            int w = exclusiveCount(c);
            if (c != 0) {
                // (Note: if c != 0 and w == 0 then shared count != 0)
                //当前有读线程拿到读锁，写线程无法获取同步状态
                if (w == 0 || current != getExclusiveOwnerThread())
                    return false;
                //写锁的可重入次数已达最大值
                if (w + exclusiveCount(acquires) > MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
                // Reentrant acquire
                //写锁可重入
                setState(c + acquires);
                return true;
            }
     		//此时读写状态为0，写锁可以正常获取到同步状态
     		//当前线程只有写锁线程
            if (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires))
                return false;
            setExclusiveOwnerThread(current);
            return true;
        }


```

- [ ] **如何区分读状态与写状态？**
  - **同步状态的高16位表示读锁获取次数；**
  - **同步状态低16位表示写锁获取次数。**

##### 4.6.3 读锁 - 共享锁（一般与独占锁搭配使用实现读写者模型）

- [ ] **读锁获取：只要当前没有写线程获取到写锁并且读锁的获取次数不超过最大值，读锁就能获取成功。**
- [ ] **读写锁的应用场景：缓存的实现**

##### 4.6.4 写锁的降级

- [ ] 写锁可以降级为读锁但是读锁不能升级为写锁

#### 4.7 Condition的await与signal  等待/通知机制

- [ ] **Object的wait、notify是与内建锁（对象监视器）搭配使用，java语言层面实现，具有更高的控制与扩展性。**
- [ ] **Condition有以下三个独有特性：**
  - **1.Condition await支持不响应中断，而Object提供的wait不支持 。**
  - **2.Condition支持多个等待队列，而Object wait只有一个等待队列。**
  - **3.Condition支持设置截止时间，而Object wait只支持设置超时时间。**
- [ ] 等待方法 await()
  - **1. void await() throws InterruptedException()//同wait();**
  - **2.void awaitUninterruptibly();特性1，等待过程中支持不响应中断**
  - **3.boolean await(long time, TimeUnit unit) throws InterruptedException;在1的基础上增加了超时等待功能，可以自定义时间单位**
  - **4.boolean awaitUntil(Date deadline) throws InterruptedException;特性3，支持设置截止时间**
- [ ] 唤醒方法signal、singnalAll()

##### 4.7.1 Condition等待队列

- [ ] Condition队列与AQS中的同步对列共享节点（N1ode）数据结构，带有头尾指针的单向队列
- [ ] 每当调用lock.newCondition()就会在绑定lock锁上新增一个等待队列（特性2）
- [ ] 应用场景：使用Condition实现有界队列

##### 4.7.2 await实现原理

```java
//源码分析
 public final void await() throws InterruptedException {
     		//判断中断
            if (Thread.interrupted())
                throw new InterruptedException();
     		//将当前线程封装为Node节点入等待队列
            Node node = addConditionWaiter();
     		//释放拿到的同步状态
            int savedState = fullyRelease(node);
            int interruptMode = 0;
            while (!isOnSyncQueue(node)) {
                //当线程不在同步队列后将其阻塞，置为WAIT状态
                LockSupport.park(this);
                if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
                    break;
            }
     		//在同步队列中排队获取锁
            if (acquireQueued(node, savedState) && interruptMode != THROW_IE)
                interruptMode = REINTERRUPT;
            if (node.nextWaiter != null) // clean up if cancelled
                unlinkCancelledWaiters();
            if (interruptMode != 0)
                reportInterruptAfterWait(interruptMode);
        }
```

- [ ] **如何将当前线程插入等待队列？--addConditionWaiter()**

```java
  private Node addConditionWaiter() {
            Node t = lastWaiter;
            // If lastWaiter is cancelled, clean out.
            if (t != null && t.waitStatus != Node.CONDITION) {
                //清空所有等待队列中状态不为Condition的节点
                unlinkCancelledWaiters();
                //将最新的尾节点赋值
                t = lastWaiter;
            }
      		//将当前线程包装为Node节点且状态为Condition
            Node node = new Node(Thread.currentThread(), Node.CONDITION);
            if (t == null)
                firstWaiter = node;
            else
                t.nextWaiter = node;
      		//尾插入等待队列
            lastWaiter = node;
            return node;
        }
```

- [ ] **将线程包装为Node节点尾插入等待队列后，线程释放锁过程fullRelease()**

```java
final int fullyRelease(Node node) {
        boolean failed = true;
        try {
            //获取当前同步状态
            int savedState = getState();
            //调用release方法释放同步状态
            if (release(savedState)) {
                failed = false;
                return savedState;
            } else {
                throw new IllegalMonitorStateException();
            }
        } finally {
            //若在释放过程中出现异常，将当前节点取消
            if (failed)
                node.waitStatus = Node.CANCELLED;
        }
    }
```

- [ ] **线程如何从await()中退出？**

```java
 while (!isOnSyncQueue(node)) {
     //阻塞在此处
     LockSupport.park(this);
     if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
         break;
 }

```

- **退出条件：**
  - 1.**在等待时被唤醒，通过break退出循环**
  - 2.**被唤醒后置入同步队列退出循环**

##### 4.7.3 signal实现原理

```java
public final void signal() {
    if (!isHeldExclusively()) {
        throw new IllegalMonitorStateException();
    }
    //拿到当前等待队列的头结点
    Node first = firstWaiter;
    if (first != null) {
        //唤醒头结点
        doSignal(first);
    }
}

private void doSignal(Node first) {
    do {
        if ( (firstWaiter = first.nextWaiter) == null)
            lastWaiter = null;
        //将头节点从等待列表移除
        first.nextWaiter = null;
        //transferForSignal方法对头结点做真正处理
    } while (!transferForSignal(first) &&
             (first = firstWaiter) != null);
}
```

##### 4.7.4 Condition下的生产-消费者模型

```java
//
class Goods {
    private String name;
    private int maxCount;
    private int count;
    private Lock lock = new ReentrantLock();
    //生产者等待多列
    private Condition producerCondition = lock.newCondition();
    //消费者等待队列
    private Condition consumerCondition = lock.newCondition();

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 生产者方法
     *
     * @param name
     */
    public void setGoods(String name) {
        try {
            lock.lock();
            while (count == maxCount) {
                //当前商品达到最大值，生产者等待
                System.out.println(Thread.currentThread().getName() + "商品已达到最大值停止生产！！！");
                producerCondition.await();
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            //唤醒消费者线程
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者方法
     */
    public void getGoods() {
        try {
            lock.lock();
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + "商品已售罄，消费者等待");
                consumerCondition.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "消费" + toString());
            //唤醒生产者线程
            producerCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                this.goods.setGoods("生产电脑");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                this.goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer,"生产者"+(i+1));
            list.add(thread);
        }
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer,"消费者"+(i+1));
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
    }
}

```

#### 4.8 LockSupport工具类

- [ ] **与内建锁的阻塞唤醒区别：**
  - **阻塞：内建锁阻塞进入BLOCKED；而LockSupport.park()进入WAIT**
  - **唤醒：内建锁由JVM随机挑选一个线程唤醒；而LockSupport.unPark(Thread thread)唤醒指定线程**

#### 4.9  死锁

- [ ] **死锁产生原因：对共享资源的上锁成环。**
- [ ] 解决死锁算法：银行家算法