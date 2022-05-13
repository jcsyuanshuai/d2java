package com.d2java.alg.ds;

public class Queue<E> extends Linkedlist<E> {

    public void enqueue(E e) {
        addLast(e);
        // addFirst(e);
    }

    public E dequeue() {
        return removeFirst();
        // removeLast();
    }


    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}

