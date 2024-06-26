package com.leetcode.algorithm.stack;


import com.leetcode.algorithm.stack.model.Animal;

import java.util.Random;
import java.util.Stack;
import java.util.UUID;

public class GenericMinStack<T extends Comparable<T>>{

    private Stack<T> dataStack;

    private Stack<T> minStack;

    public GenericMinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T item) {
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else if (minStack.peek().compareTo(item) <= 0) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(item);
        }
        dataStack.push(item);
    }

    public T getMin() {
        return minStack.peek();
    }

    public T pop() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("The stack is empty!");
        }
        minStack.pop();
        return dataStack.pop();
    }


    public static void main(String[] args) {
        GenericMinStack obj = new GenericMinStack();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            obj.push(new Animal(UUID.randomUUID().toString(), random.nextInt(100)));
        }

        System.out.printf("dataStack:%s\n", obj.dataStack);
        System.out.printf("MinStack:%s\n", obj.minStack);
    }
}
