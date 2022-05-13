package com.d2java.alg.ds;

public class Stack<E> extends Linkedlist<E> {
    public void push(E e) {
        addFist(e);
        //addLast(e);
    }

    public E pop() {
        return removeFirst();
        //return removeLast();
    }

    public E peek() {
        return peekFirst();
        //return peekLast();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
