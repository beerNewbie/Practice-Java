package per.hbc.testThreadPool;

import java.util.concurrent.*;

/**
 * @Author: Beer
 * @Date: 2019/5/20 16:04
 * @Description:
 */

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
    }
}

class MyThread1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
        return Thread.currentThread().getName()+"执行完毕";
    }
}

public class TestCreatThreadPool {
    public static void main1(String[] args) {
        MyThread myThread = new MyThread();
        //手工创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 5,
                2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            executorService.execute(myThread);
        }
        /**
         * 结果：
         * pool-1-thread-3、0
         * pool-1-thread-2、0
         * pool-1-thread-2、1
         * pool-1-thread-2、2
         * pool-1-thread-2、3
         * pool-1-thread-2、4
         * pool-1-thread-2、5
         * pool-1-thread-1、0
         * ...
         */
    }

    public static void main2(String[] args) {
        MyThread1 myThread = new MyThread1();
        //手工创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 5,
                2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            executorService.submit(myThread);
        }
        /**
         * 结果：
         * pool-1-thread-1、0
         * pool-1-thread-2、0
         * pool-1-thread-2、1
         * pool-1-thread-1、1
         * pool-1-thread-1、2
         * pool-1-thread-1、3
         * pool-1-thread-1、4
         * pool-1-thread-3、0
         * 。。。
         */
    }

    public static void main(String[] args) throws Exception{
        MyThread1 myThread = new MyThread1();
        //手工创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 5,
                2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            Future future = executorService.submit(myThread);
           // System.out.println(future.get());
        }
        //关闭线程池
        executorService.shutdown();
        /**
         * 结果：
         * pool-1-thread-1、0
         * pool-1-thread-1、1
         * pool-1-thread-1、2
         * pool-1-thread-1、3
         * pool-1-thread-1、4
         * pool-1-thread-1、5
         * pool-1-thread-1、6
         * pool-1-thread-1、7
         * pool-1-thread-1、8
         * pool-1-thread-1、9
         * pool-1-thread-1执行完毕
         * pool-1-thread-2、0
         * pool-1-thread-2、1
         * pool-1-thread-2、2
         * pool-1-thread-2、3
         * pool-1-thread-2、4
         * pool-1-thread-2、5
         * pool-1-thread-2、6
         * pool-1-thread-2、7
         * pool-1-thread-2、8
         * pool-1-thread-2、9
         * pool-1-thread-2执行完毕
         * pool-1-thread-3、0
         * pool-1-thread-3、1
         * pool-1-thread-3、2
         * pool-1-thread-3、3
         * pool-1-thread-3、4
         * pool-1-thread-3、5
         * pool-1-thread-3、6
         * pool-1-thread-3、7
         * pool-1-thread-3、8
         * pool-1-thread-3、9
         * pool-1-thread-3执行完毕
         * pool-1-thread-1、0
         * pool-1-thread-1、1
         * pool-1-thread-1、2
         * pool-1-thread-1、3
         * pool-1-thread-1、4
         * pool-1-thread-1、5
         * pool-1-thread-1、6
         * pool-1-thread-1、7
         * pool-1-thread-1、8
         * pool-1-thread-1、9
         * pool-1-thread-1执行完毕
         * pool-1-thread-2、0
         * pool-1-thread-2、1
         * pool-1-thread-2、2
         * pool-1-thread-2、3
         * pool-1-thread-2、4
         * pool-1-thread-2、5
         * pool-1-thread-2、6
         * pool-1-thread-2、7
         * pool-1-thread-2、8
         * pool-1-thread-2、9
         * pool-1-thread-2执行完毕
         */
    }
}
