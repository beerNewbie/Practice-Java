# `JDK1.8后HashMap`源码深度分析：

### 1.成员变量：

##### 1.1 初始化容量--桶的数量（16）：`static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16`

##### 1.2 最大容量：`static final int MAXIMUM_CAPACITY = 1 << 30;`

##### 1.3 负载因子：`static final float DEFAULT_LOAD_FACTOR = 0.75f;`

##### 1.4 树化阈值（默认为8）：`static final float DEFAULT_LOAD_FACTOR = 0.75f;`

##### 1.5 树化的最少元素个数（64）：`static final int MIN_TREEIFY_CAPACITY = 64;`

##### 1.6 解除树化，返回链表的阈值（6）：`static final int UNTREEIFY_THRESHOLD = 6;`

##### 1.7 真正存储元素的哈希表：`transient Node<K,V>[] table;`

### 2.逻辑分析

##### 2.1 树化逻辑：

- [ ] 当一个桶中链表的**元素个数大于等于8**，并且哈希表中的**所有元素的个数超过64**，则会将此桶中**链表结构转化为红黑树**结构。否则只进行扩容，不会树化。
- [ ] 好处：优化链表过长导致查找性能急剧降低`O(n)-->O(logn)`，并且可以**减小哈希碰撞提高安全性**

##### 2.2 查找逻辑：

- [ ] 先根据它的hash值找出其位于哪一个桶，再根据value值在该桶后的链表中查找`(O(n))`,在二叉树中查找`(O(logn))`

### 3.构造函数

##### 3.1 无参构造：初始化负载因子

```java
	public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // 默认0.75
    }
```

##### 3.2 有参构造：

```java
	//传入初始化容量
	public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

	//传入初始化容量和负载因子
	public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }
```

##### 3.3 由上面的构造函数可知`HashMap`如同`ArrayList`同样采取懒加载策略，不会在对象产生时初始化哈希表

### 4.核心方法

##### 4.1 put方法：

```java
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

	/**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value 如果是false，则可以替换掉key值相同的value值
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
```

> ==`putVal方法：`==

```java
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //判断当前哈希表是否初始化
        if ((tab = table) == null || (n = tab.length) == 0)
            //resize方法完成哈希表的初始化
            n = (tab = resize()).length;
        //判断以key值哈希后得到的下标的桶，其中是否存在元素（这里就是要保证桶的数量为2^n，因为当n位2^n时 (n-1) & hash 相当于 hash % (n-1))
        if ((p = tab[i = (n - 1) & hash]) == null)
            //将要保存的节点放在此桶的第一位置
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            //判断节点是否处于同一个桶并且key值完全相同
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                //替换头结点
                e = p;
            //hash(key)桶中元素不为空，判断此桶是否树化
            else if (p instanceof TreeNode)
                //调用树化后的方法，将新节点添加到红黑树中
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            //桶中元素不为空，并且仍是链表
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        //将新节点链到链表尾部
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //判断添加元素后的哈希表大小是否超过阈值（而ArrayList是先检查再添加元素）
        if (++size > threshold)
            //扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }

```

> `putValue`逻辑图
>
> 

![](C:\Users\DELL\Desktop\图片\image\HashMapPutValue.PNG)







### 5.常见问题

##### 5.1 为何不采用Object类提供的`hashCode()`计算出来的key值作为桶下标：

- [ ] 基本不会发生碰撞，此时哈希表和普通数组基本没有区别

##### 5.2 为何 h >>> 16 ?

- [ ] 因为hash基本是在高16 位进行hash运算

##### 5.3 为何`HashMap`中容量均为2^n?

- [ ] 因为当n位2^n时 (n-1) & hash 相当于 hash % (n-1)
