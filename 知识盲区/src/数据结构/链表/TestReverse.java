package 数据结构.链表;


/**
 * @Author: Beer
 * @Date: 2019/8/21 23:27
 * @Description:
 */

class Node {
    Node next = null;
    int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}
public class TestReverse {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node res = reverse(node1);
        for (; res != null; res = res.next) {
            System.out.print(res.val);
            if (res.next != null) {
                System.out.print( "->");//5->4->3->2->1
            }
        }

    }
    public static Node reverse(Node head) {
        Node newNode = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;

            cur.next = newNode;
            newNode = cur;

            cur  = next;
        }

        return newNode;
    }
}
