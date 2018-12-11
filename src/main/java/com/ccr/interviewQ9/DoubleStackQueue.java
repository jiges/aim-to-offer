package com.ccr.interviewQ9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class DoubleStackQueue<T> {

    private Stack<T> appendStack;

    private Stack<T> deleteStack;

    public DoubleStackQueue() {
        this.appendStack = new Stack<>();
        this.deleteStack = new Stack<>();
    }

    public void appendTail(T node) {
        appendStack.push(node);
    }

    public T deleteHead() {
        if(deleteStack.empty()) {
            while (!appendStack.empty()) {
                deleteStack.push(appendStack.pop());
            }
        }

        return deleteStack.pop();
    }

}
