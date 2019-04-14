### Java类集（数据结构-多线程）-java.util.*
[动态数组(当元素个数达到最大值时，动态增加容量)]()
#### 1.Java类集产生-JDK1.2
**动态数组：解决定长问题**
##### 1.2 Collection接口-[单个对象]()保存的最顶层父接口
- [x] Collection接口及其子接口，在每次进行数据操作时只能对单个对象进行处理。
- public interface Collection<E> extends Iterable<E>
- [x] Iterable<E>:迭代器接口（就是为了遍历集合）
- [x] iterator<T> iterator();(取得集合的迭代器，JDK1.5之前直接写在Collection接口中)
- [x] Collection接口中提供的核心方法：
- [add(T t):向类集中添加元素]()
- [iterator():取得类集的迭代器]()
- Collection接口只定义了存储数据的标准，但无法区分存储类型。因此在实际中往往使用两个子接口List（允许数据重复）、Set（不允许数据重复）。一般不直接使用Collection接口。
#### 2.List接口
在进行单个集合处理时，优先考虑List接口
- [x] 在List接口中拓展了两个重要方法（List接口独有）
- public E get(int index) :根据索引下标取得数据；
- public E set(int index,E element) :根据索引下标更新数据，返回修改前数据
- [x] List接口有三个重要子类[ArrayList(90%)、Vector、LinkedList](),这三个子类在使用上没有任何区别
- [x] List接口要保存自定义类的对象，该类必须覆写equals()来使用contains()、remove()等方法
```
//覆写equals()方法
@Override
public boolean equals(Object obj) {
    if (obj == this) {
        return true;
    }else if (obj == null) {
        return false;
    }else if (!(obj instanceof Person)) {
        return false;
    }
    //向下转型还原为Person对象
    Person person = (Person) obj;
    retrun this.age.equals(per.age) && this.name.equals(per.name);
}
```
##### [Important]:==ArrayList、Vector、LinkedList的区别：==
- [ ] ArrayList、LinkedList的区别： 
- 1、出现版本：ArrayList -->JDK1.2 而Vector-->JDK1.0(出现在List、Collection接口之前)
- 2、初始化策略区别：Vector在无参构造执行后将对象数组大小初始化为10；ArrayList采用懒加载策略，在构造方法阶段并不初始化对象数组，在第一次添加元素时才初始化对象数组大小为10
- 3、扩容策略：ArrayList扩容时，新数组变为原数组的1.5倍，Vector扩容时，新数组大小变为原数组的2倍；
- 4、线程安全性：ArrayList采用异步处理，线程不安全，效率较高；Vector采用方法上加锁(synchronized关键字(同步的，代表这个方法加锁))，线程安全，效率较低。（即便使用线程安全的List，也不用Vector）
- 5、遍历：Vector支持较老的Enumeration，ArrayList不支持，ArrayList支持Iterator、ListIterator、foreach；Vector支持Iterator、ListIterator、foreach、
Enumeration。
- [ ] ArrayList、Vector的共同点：底层均使用数组实现
- [x] ArrayList、LinkedList区别：LinkedList底层采用双向链表实现，ArrayList底层采用数组实现
### 3.Set接口
- [x] **不允许数据重复（Set接口就是Value值相同的Map集合，先有Map才有Set），Set接口没有扩充方法**
#### Set接口常用子类：
##### HashSet（无序存储）-HashMap：
- [ ] 1、底层使用 哈希表+红黑树
- [ ] 2、允许存放null，无序存储
##### TreeSet（有序存储）- TreeMap：Comparable、Compartor
- [ ] 1、底层使用红黑树
- [ ] 2、不允许出现null，有序存储
- [ ] 3、自定义类要想保存到TreeSet中，要么实现Comparable接口，要么向TreeSet传入比较器（Comparator接口）
###### Comparable与Commparator的区别：
- [ ] 在Java中，若想实现自定义类的比较，提供了以下两个接口：
> **java.lang.Comparable接口（内部比较器）-排序接口**：
- 若一个类实现了Comparable接口，就意味着该类支持排序。存放该类的Collection或数组，可以直接通过Collections.sort()或Array.sort()进行排序。
- 实现了Comparable接口的类可以直接放在TreeSet或TreeMap中
- [public int compareTo(); 返回值三种情况：]()**返回正数**：表示当前对象大于目标对象；**返回0**：表示当前对象等于目标对象；**返回负数** ：表示当前对象小于目标对象
```
//覆写compareTo,自定义Person类如何比较大小（按年龄）
@Override
public int compareTo(Person o) {
    if (this.age > o.age) {
        return 1;
    }else if (this.age < o.age) {
        return -1;
    }else {
        return this.name.compareTo(o.name);
    }
}

```
> **Comparator(外部排序接口):**
-  若要控制某个自定义类的顺序，而该类本身不支持排序（该类本身没有实现Comparable接口）。我们可以建立一个该类的“比较器”来进行排序。比较器实现Comparator接口即可。
-  "比较器"：实现了Comparator接口的类作为比较器，通过该比较器来进行类的排序。
- [public int compare(T o1, T o2);返回值与compareTo返回值完全一样：]()返回正数：o1 > o2;返回0：o1 = o2;返回负数：o1 < o2;
- 实现了Comparator接口进行第三方排序- **策略模式** ，此方法更加灵活，可以轻松改变策略进行第三方的排序算法
```
//Person类的比较器
class AscAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1,Person o2) {
        reeturn o1.getAge() - o2.getAge();
    }
    //只重写了compare方法，而equals方法在Object类中就已经写了
}
```
##### Comparable接口与Comparator接口的关系：
- [x] Comparable 是排序接口，若一个类实现了Comparable接口，意味着该类支持排序，是一个内部比较器（自己和别人去比）
- [x] Comparator接口是比较器接口，类本身不支持排序，专门有若干个第三方的比较器（实现了Comparator接口）来进行排序比较，是一个外部比较器（策略模式）
##### 重复元素的判断：
- [x] TreeSet与TreeMap依靠Comparator或Comparable接口来区分重复元素。
##### 自定义类要想保存在TreeMap或TreeSet中：
- [ ] 要么该类直接实现Comparable接口，覆写compareTo方法
- [ ] 要么实现一个比较器，传入TreeSet或TreeMap来进行外部比较
##### 而HashSet与HashMap并不依赖比较接口。此时要想区分自定义元素是否重复，需要同时覆写equals与hashCode方法
- [ ] 首先覆写equals()方法来判定元素内容是否相等。
- [ ] 覆写equals方法原则：
- 自反性：对于任何非空引用值想x, x.equals(x)都返回true
- 对称性：对于任何非空x,y,当且仅当x.equals(y)返回true，y.equals(x)也返回true
- 传递性：对于任何非空x,y,z,若x.equals(y)返回true，y.equals(z)返回true，一定有x.equals(z)返回true
- 一致性：对于任何非空的x,y,若想x与y的属性没有发生改变，则多次调用x.equals(y)始终返回true或false
- 非空性：对于任何的非空x，x.equals(null)一定返回false
- [ ] 先调用hashCode计算出hash码决定存放的数据桶，而后使用equals来比较元素是否相等，若相等，则不放置元素；若equals返回false。则在相同桶之后，使用链表将若干元素链起来。（先hashCode，若在一个数据桶再equals）
- Object类提供的hashCode方法默认使用对象的地址进行hash
```
//覆写hashCode ，把两个值做hash，而不是地址，hashCode保证属性值相同的元素一定在一个桶中，equals方法保证若是不一个东西就set
public int hashCode() {
    return Objects.hash(age,name);
}
```
- [ ] **若两个equals方法返回true，他们的hashCode必然保证相等（相同值的hash码一定相等）。但两对象的hashCode相等equals不一定相等，当且仅当equals与hashCode均返回true，才认为两个对象真的相等**
- [ ] 哈希表：优化查找次数
### 4. 集合输出(迭代器输出)-Iterator接口
- [ ] 迭代器：为了遍历集合而生。-迭代器模式
#### Iterator接口的两个核心方法：
- [ ] [boolean hasNext(); 判断是否还有元素]()
- [ ] [E next(); 取得下一个元素]()
##### 4.1迭代器输出Iterator-只能从前向后输出
- [ ] 调用Collection集合的子类Iterator方法取得内置迭代器，使用以下格式输出：
```
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```
##### 4.2 双向迭代接口ListIterator-List支持，Set不支持
- [ ] 除了hasNext与next方法外，还有：
- hasPrevious():判断是否有上一个元素
- previous：取得上一个元素
- [ ] 要想使用从后向前遍历输出，首先至少要从前向后遍历一次才可使用
##### 4.3 Enumeration（JDK1.0）枚举输出-Vector类支持
- [ ] hasMoreElements():判断是否有下一个元素
- [ ] nextElements():取得下一个元素
##### 4.4 for-each输出（所有子类都满足）
- [ ] 能使用for-each输出的本质在于各个集合类都内置迭代器

##### fail-fast机制：
- [ ] ConcurrentModificationExcetion发生在Collection集合使用迭代器遍历时，使用了集合类提供的修改集合内容方法报错。而如果使用Iterator迭代器的remove()不会出现此错误。
```
//出错机制：
final void checkForComodification() {
    if (modCount != expectedModCount)
        throw new ConcurrentModificationException;
}
```
- Collection 集合中的modCount表示当前集合的修改次数
- expectModcount是迭代器中记录当前集合的修改次数，当取得集合迭代器时（即调用list.iterator()）,exceptedModCount = modCount，换言之，迭代器就是当前集合的一个副本。
- 快速失败策略保证了所有用户在进行迭代遍历集合时，拿到的数据一定是最新的数据。（避免“脏读产生”）
- **fail-safe:** 不产生ConCurrentModificationException异常，jar包下所有的线程安全集合（CopyOnWriteArrayList）
- **总结：以后在迭代器遍历时，不要修改集合内容**
```
//eg：
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","B","C","D","E");
        //modCount = 6
        Iterator<String> iterator = list.iterator();
        //取得集合迭代器（取得当前集合的副本）
        //expectedModCount = 6
        while(iterator.hasNext()) {
            //调用checkForComodification检查副本中的exceptedModCount是否等于集合的modCount
            String str = iterator.next();
            if (strr.equals("B")) {
                //list.remove("B");//集合类提供的remove方法，报错：ConcurrentModeficationException;
                iterator.remove();//正确
                continue;
            }
            System.out.println(str);
        }
    }
}
```
## 5.Map集合
##### Map接口是Java中保存二元偶对象（键值对）的最顶层接口
[public interface Map<K,V> key值唯一，通过key值一定能唯一找到一个value值]()
##### Map接口中的核心方法：
- **public V put(K key,V value):向Map中添加数据**
- **public V get(K key) :根据指定的key值取得相应的value值，若没有key值则返回null**
- [public Set<Map.Entry<K,V>> entrySet() : 将Map集合变为Set集合]()
- **public Set<K> keySet()** : 返回所有key值，**key不能重复**。
- **public Collection<V> values()** : 返回所有value值，**value可以重复**。
#### Map接口有如下常用子类：
[HashMap、TreeMap、HashTable、ConcurrentHashMap]()
#### HashMap与HashTable区别：
- [ ] HashMap-类比HashSet
- 1.允许key和value为null，且key值有且只有一个为null，value可以有任意多个为null
- 2.JDK1.2产生
- 3.异步处理效率高，线程不安全
- 4.底层：hash表+红黑树（JDK8）
- [ ] HashTable
- 1.key与value均不为null
- 2.JDK1.0产生
- 3.使用方法加锁，效率低，线程安全
- 4.底层hash表
#### Map集合使用迭代器输出：
- [ ] Set<Map.Entry<K,V>> entrySet():将Map集合转为Set集合
```
public class TestMapIterator {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Python");
        //Map——>Set
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //取得Set接口迭代器
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        //迭代输出
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
```
### 6.栈和队列
#### 栈：先入后出-Vector
 **应用：** 函数栈帧，浏览器网页的后腿，安卓Activity的后退 ，编译器撤销
 - 入栈：push
 - 出栈：pop
 - 返回栈顶元素但不出栈：peek()
 - [ ] 自己实现一个html识别器：
 ```
 public class Test {
     public static void main(String[] args) {
         Stack stack = new Stack();
         stack.push(1);
         stack.push(2);
         stack.push(3);
         System.out.println(stack.peek());//3
         System.out.println(stack.pop());//3
         System.out.println(stack.pop());//2
         System.out.println(stack.pop());//1
         System.out.println(stack.pop());//报错：EmptyStackException
     }
 }
 ```
#### 队列FIFO：先入先出
**Queue接口-LinkedList**

[Queue<Integer> queue = new LinkedList<>();]() 
- 入队列：add()
- 出队列：poll()
- 返回队列头元素，不出对：peek()
- 消息队列：kafka,RobitMQ
```
public class Test {
     public static void main(String[] args) {
         public static void main(String[] args) {
                 Queue<Integer> queue = new LinkedList<>();
                 queue.add(1);
                 queue.add(2);
                 queue.add(3);
                 System.out.println(queue.peek());//1
                 System.out.println(queue.poll());//1
                 System.out.println(queue.poll());//2
                 System.out.println(queue.poll());//3
                 System.out.println(queue.poll());//null
             }
     }
 }
```
### 7.资源文件操作（Properties属性文件）
**资源文件内容都是k-v 格式，并且无论key、value都是String类型
##### 设置属性
- setProperty(String key,String value) 返回Object
##### 取得属性
- getProperty(String key,String value) 返回String,若没有指定key，返回null
- getProperty(String key,String defaultValue):若没有指定key值返回默认值
##### 将资源内容输入输出到目标终端
- 输出到目标终端：store(OutputStream out,String comments);
- 从目标终端中读取数据：load(InputStream in);
### 8.Collections工具类
##### 1.将线程不安全的集合包装为线程安全的集合
- [ ] 在add、remove等方法修改上使用了同步代码块保证线程安全，效率较低。**要使用线程安全集合，推荐使用juc包下的并发集合类（ConcurrentHashMap、CopyOnWriteArrayList）**
- [ ] 集合排序
- Collection.sort(集合名称)
- [ ] 集合反转
- Collections.reverse(集合名称)
```
public class TestCollections01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //向集合中一次添加多个元素
        Collections.addAll(list, "A", "a", "k", "K", "B", "b");
        //集合排序
        Collections.sort(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        iterator = list.iterator();
        //集合反转
        Collections.reverse(list);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
/**
 * 结果：
 * A B K a b k
 *
 * k b a K B A
 */
```
### 9.Stream数据流:Collection接口
[核心方法:取得Stream流 Stream<E> stream()]()
##### 常用方法：
- [ ] forEach:集合输出
- [ ] filter:数据过滤
- [ ] 取得最大最小值：max/min
```
public class TestStream01 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);
        //list.forEach(System.out::print);
        Stream<Integer> stream = list.stream();
        //偶数个数
   /*     System.out.println("count = " +
                stream.filter(e -> e % 2 == 0).count());*/
        //求集合中的最大最小值
        System.out.println(stream.max(Integer::compareTo)
                .get());
    }
}
```
##### Map/Reduce模型
- [ ] map():前期数据的处理
- [ ] reduce():数据处理后的收集
```
class Goods {
    private String name;
    private Integer count;
    private Double price;

    public Goods(String name, Integer count, Double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
public class TestMapAndReduce {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("HUAWEI",500,6000.00));
        list.add(new Goods("APPLE",200,7000.00));
        list.add(new Goods("XIAOMI",600,3000.00));
        list.add(new Goods("OPPO",300,3500.00));
        Double costs = list.stream()
                .map(obj -> obj.getCount()*obj.getPrice())
                .reduce((sum,x) -> sum+x).get();
        System.out.println(costs);
    }
}
//结果：7250000.0
```