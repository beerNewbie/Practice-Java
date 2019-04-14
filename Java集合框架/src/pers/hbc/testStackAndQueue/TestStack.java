package pers.hbc.testStackAndQueue;

import java.util.Stack;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:17
 * @Description:
 */
public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());//3
        System.out.println(stack.pop());//3
        System.out.println(stack.pop());//2
        System.out.println(stack.pop());//1
        //System.out.println(stack.pop());//报错：EmptyStackException
    }
}
