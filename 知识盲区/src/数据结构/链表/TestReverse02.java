package 数据结构.链表;


/**
 * @Author: Beer
 * @Date: 2019/8/22 0:00
 * @Description:
 */

public class TestReverse02 {
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
        Node res = reverseNode(node1);
        for (; res != null; res = res.next) {
            System.out.print(res.val);
            if (res.next != null) {
                System.out.print( "->");//5->4->3->2->1
            }
        }
    }

    /**
     * 三指针法
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node cur = head;
        Node next = cur.next;

        while (cur != null) {
            //逆转指向
            cur.next = pre;

            //将引用指向正确的位置
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }

        }

        return pre;
    }
}
