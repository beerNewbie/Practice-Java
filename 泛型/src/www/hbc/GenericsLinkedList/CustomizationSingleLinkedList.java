package www.hbc.GenericsLinkedList;

/**
 * @Author: Beer
 * @Date: 2019/3/18 15:40
 * @Description:单链表的增删查改
 */
public class CustomizationSingleLinkedList<T> {
    //定义一个内部类Node，Node实例代表链表节点
    public class Node {
        private T data;
        private Node next;
        private Node() {}
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //头结点
    private Node head;
    //尾节点
    private Node tail;
    //节点个数
    private int size;
    //创建空链表
    public CustomizationSingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //以指定元素来创建链表，该链表只有一个元素
    public CustomizationSingleLinkedList(T data) {
        this.head = new Node(data,null);
        this.tail = this.head;
        this.size++;
    }

    /**
     * 链表长度
     * @return
     */
    public int length() {
        return this.size;
    }
    public T get(int index){
        Node node = this.getNodeByIndex(index);
        return node == null ? null : node.data;
    }
    private Node getNodeByIndex(int index) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < this.size && cur != null; i++, cur = cur.next) {
            if (i == index) {
                return cur;
            }
        }
        return null;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("下标非法！");
        }
    }

    /**
     * 查找指定元素下标
     * @param data
     * @return
     */
    public int located(T data) {
        Node cur = this.head;
        for (int i = 0; i < this.size && cur != null; i++, cur = cur.next) {
            if (cur.data.equals(data)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 向指定位置插入元素
     * @param data
     * @param index
     */
    public void insert(T data, int index) {
        checkIndex(index);
        //链表为空
        if (this.head == null) {
            this.add(data);
        }else {
            if (index == 0) {
                addHead(data);
            }else {
                Node preNode = this.getNodeByIndex(index - 1);
                if (preNode == null) {
                    throw new IllegalArgumentException("index = " + (index - 1) + " not found node!!!");
                }
                preNode.next = new Node(data,preNode.next);
                this.size++;
            }
        }
    }

    /**
     * 尾插法
     * @param data
     */
    public void add(T data) {
        if (this.head == null) {
            this.head = new Node(data,null);
            this.tail = this.head;
        }else {
            Node newNode = new Node(data,null);
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * 头插法
     * @param data
     */
    public void addHead(T data) {
        this.head = new Node(data,head);
        if (this.tail == null) {
            this.tail = this.head;
        }
        this.size++;
    }

    /**
     * 删除指定索引处的元素
     * @param index
     * @return
     */
    public  T delete(int index) {
        checkIndex(index);
        Node delNode;
        if (index == 0) {
            delNode = this.head;
            this.head = this.head.next;
        }else {
            Node preNode = this.getNodeByIndex(index - 1);
            if (preNode == null) {
                throw new IllegalArgumentException("index = " + (index - 1) + " not found node!!!");
            }
            delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next = null;
        }
        this.size--;
        return delNode.data;
    }

    /**
     * 删除链表最后 一个元素
     * @return
     */
    public T remove() {
        return this.delete(this.size - 1);
    }

    /**
     * 判断链表是否。为空
     * @return
     */
    public boolean empty() {
        return this.size == 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = this.head; cur != null; cur = cur.next) {
            sb.append(cur.data.toString()).append(",");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomizationSingleLinkedList<String> list =
                new CustomizationSingleLinkedList<>();
        list.add("Java");
        list.add("C++");
        list.add("C");
        list.add("PHP");
        list.add("Python ");

        System.out.println(list);
        list.insert("易语言",0);
        System.out.println(list);
        list.delete(3);
        System.out.println(list);
        System.out.println(list.empty());
        list.clear();
        System.out.println(list);
        System.out.println(list.empty());
    }
}
