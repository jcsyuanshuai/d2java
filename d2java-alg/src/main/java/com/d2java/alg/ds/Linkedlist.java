package com.d2java.alg.ds;

public class Linkedlist<E> {

    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    protected static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // 头插法：前一位总是为null
    protected void addFist(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            this.last = newNode;
        } else {
            f.prev = newNode;
        }
        this.size++;
    }

    // 尾插法：后一位总是为null
    protected void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        this.size++;
    }

    protected E removeFirst() {
        final Node<E> f;
        if ((f = first) != null) {
            final E e = f.item;
            final Node<E> next = f.next;
            f.item = null;
            f.next = null;
            first = next;
            if (next == null) {
                last = null;
            } else {
                next.prev = null;
            }
            size--;
            return e;
        }
        return null;
    }

    protected E removeLast() {
        final Node<E> l;
        if ((l = last) != null) {
            final E e = l.item;
            final Node<E> prev = l.prev;
            l.item = null;
            l.prev = null;
            last = prev;
            if (prev == null) {
                first = null;
            } else {
                prev.next = null;
            }
            size--;
            return e;
        }
        return null;
    }

    protected E peekFirst() {
        final Node<E> f = first;
        return f == null ? null : first.item;
    }

    protected E peekLast() {
        final Node<E> l = last;
        return l == null ? null : last.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(E e) {
        addLast(e);
    }

}
