package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class LinkedListDeque<T> {
    public class List<T> {
        private T item;
        private List<T> next;
        private List<T> prev;

        public List(T i, List p, List n) {
            item = i;
            prev = p;
            next = n;
        }

        public T getItem() {
            return item;
        }
    }

    // The first Item is sentienl.next.
    private List<T> sentienl; // 哨兵
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentienl = new List<>(null, null, null);
    }

    public LinkedListDeque(T x) {
        size = 1;
        sentienl = new List<>(null, null, null);
        sentienl.next = new List(x, null, null);

        sentienl.next.prev = sentienl;
        sentienl.next.next = sentienl;
        sentienl.prev = sentienl.next;
        sentienl.next = sentienl.prev;
    }

    public void addFirst(T item) {
        // add T item at the First
        size += 1;
        List<T> p = new List<>(item, null, null);
        if (size == 1) {
            p.prev = sentienl;
            p.next = sentienl;
            sentienl.next = p;
            sentienl.prev = p;
        } else {
            p.prev = sentienl;
            p.next = sentienl.next;
            sentienl.next.prev = p;
            sentienl.next = p;
        }

    }

    public void addLast(T item) {
        // add T item at the Last
        size += 1;
        List<T> p = new List<>(item, null, null);
        if (size == 1) {
            p.prev = sentienl;
            p.next = sentienl;
            sentienl.next = p;
            sentienl.prev = p;
        } else {
            p.prev = sentienl.prev;
            p.next = sentienl;
            sentienl.prev.next = p;
            sentienl.prev = p;
        }
    }

    public T removeLast() {
        // The first is static
        if (isEmpty()) {
            return null;
        }
        T lastItem = sentienl.prev.getItem();
        sentienl.prev = sentienl.prev.prev;
        sentienl.prev.next = sentienl;
        size -= 1;
        return lastItem;
    }

    public T removeFirst() {
        // The last is static
        if (isEmpty()) {
            return null;
        }
        T firstItem = sentienl.next.getItem();
        sentienl.next = sentienl.next.next;
        sentienl.next.prev = sentienl;
        size -= 1;
        return firstItem;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        List<T> p = sentienl.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.getItem();
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return subRecursive(index, sentienl.next);
    }

    public T subRecursive(int index, List<T> list) {
        if (index == 0) {
            return list.getItem();
        }
        return subRecursive(index - 1, list.next);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        List<T> p = sentienl.next;
        for (int i = 0; i < size; i += 1) {
            System.out.println(p.getItem());
            p = p.next;
        }
        System.out.println();
    }

    // TODO: Two special methods
}