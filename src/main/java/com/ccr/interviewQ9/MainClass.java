package com.ccr.interviewQ9;

public class MainClass {

    public static void main(String[] args) {

        DoubleStackQueue<String> queue = new DoubleStackQueue<>();

        queue.appendTail("A");
        queue.appendTail("B");
        queue.appendTail("C");

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail("D");
        queue.appendTail("E");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
//        System.out.println(queue.deleteHead());

    }

}
