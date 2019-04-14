package pers.hbc.testStackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:20
 * @Description:
 */
public class TestQueue {
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
