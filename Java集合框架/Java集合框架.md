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
- 5、遍历：Vector支持较老的Enumeration，ArrayList不支持
- [ ] ArrayList、Vector的共同点：底层均使用数组实现
- [x] ArrayList、LinkedList区别：LinkedList底层采用双向链表实现，ArrayList底层采用数组实现
### 3.Set接口
- [x] 不允许数据重复，Set接口没有扩充方法
#### Set接口常用子类：
##### HashSet（无序存储）：
- [ ] 1、底层使用 哈希表+红黑树
- [ ] 2、允许存放null，无序存储
##### TreeSet（有序存储）：Comparable、Compartor
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
- [ ] 先调用hashCode计算出hash码决定存放的数据桶，而后使用equals来比较元素是否相等，若相等，则不放置元素；若equals返回false。则在相同桶之后，使用链表将若干元素链起来
- Object类提供的hashCode方法默认使用对象的地址进行hash
```
//覆写hashCode
public int hashCode() {
    return Objects.hash(age,name);
}
```
- [ ] 若两个equals方法返回true，他们的hashCode必然保证相等。但两对象的hashCode相等equals不一定相等