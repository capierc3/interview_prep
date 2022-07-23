package com.company;

import java.util.Stack;

public class stacks {

    private static class MyQueue {

        private static Stack<Integer> stack1 = new Stack<>();
        private static Stack<Integer> stack2 = new Stack<>();

        public static void push(int d) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack2.push(d);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }

        public static int pop() {
            return stack1.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue.push(1);
        MyQueue.push(2);
        MyQueue.push(3);
        MyQueue.push(4);
        MyQueue.push(5);
        System.out.println(MyQueue.pop());
        System.out.println(MyQueue.pop());
    }

}
