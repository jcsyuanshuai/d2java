package com.d2java.alg.ds;

import java.util.Objects;

public class Hashmap<K, V> {

    static class Node<K, V> {
        final int hash;
        final K key;
        V val;
        Node<K, V> next;

        Node(int hash, K key, V val, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getVal() {
            return this.val;
        }

        public final int hashcode() {
            return Objects.hashCode(key) ^ Objects.hashCode(val);
        }

        public final V setVal(V newVal) {
            V oldVal = this.val;
            this.val = newVal;
            return oldVal;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o instanceof Node) {
                Node<?, ?> e = (Node<?, ?>) o;
                return Objects.equals(key, e.getKey()) && Objects.equals(val, e.getVal());
            }

            return false;
        }

    }

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    Node<K, V>[] table;

    int size;

    int modCount;

    int threshold;

    public Hashmap(int cap) {

    }

    public V get(K key) {
        Node<K, V>[] tab;
        int h, n;
        K k;
        Node<K, V> e;
        if ((tab = table) == null || (n = tab.length) == 0 ||
                (e = tab[(n - 1) & (h = hash(key))]) == null) {
            return null;
        }

        do {
            if (e.hash == h && ((k = e.key) == key ||
                    (key != null) && key.equals(k))) {
                return e.val;
            }
        } while ((e = e.next) != null);

        return null;
    }

    public V put(K key, V val) {
        Node<K, V>[] tab;
        int h, n, i;
        K k;
        Node<K, V> e, p;
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }

        if ((p = tab[i = ((n - 1) & (h = hash(key)))]) == null) {
            tab[i] = new Node<>(h, key, val, null);
        } else {
            if ((p.hash == h) && ((k = p.key) == key || key.equals(k))) {
                e = p;
            } else {
                while (true) {
                    if ((e = p.next) == null) {
                        p.next = new Node<>(h, key, val, null);
                        break;
                    }
                    if ((e.hash == h) && ((k = e.key) == key || key.equals(k))) {
                        break;
                    }
                    p = e;
                }
            }

            if (e != null) {
                V old = e.val;
                e.val = val;
                return old;
            }
        }

        ++modCount;
        if (++size > threshold) {
            resize();
        }

        return null;
    }

    public static final int MAXIMUM_CAP = 1 << 30;
    public static final int INITIAL_CAP = 1 << 4;
    public static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;

        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAP) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAP &&
                    oldCap >= INITIAL_CAP) {
                newThr = oldThr << 1;
            }
        } else {
            newCap = INITIAL_CAP;
            newThr = (int) (LOAD_FACTOR * INITIAL_CAP);
        }

        threshold = newThr;

        Node<K, V>[] newTab = new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int i = 0; i < oldCap; ++i) {
                Node<K, V> e;
                if ((e = oldTab[i]) == null) {
                    continue;
                }

                oldTab[i] = null;
                if (e.next == null) {
                    newTab[e.hash & (newCap - 1)] = e;
                } else {
                    while ((e = e.next) != null) {
                        if ((e.hash & oldCap) == 0) {
                            //todo
                        }
                    }
                }
            }
        }

        return newTab;
    }

}
