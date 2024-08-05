package deque;

import java.util.SplittableRandom;

public class ArrayDeque<T> implements Deque<T> {
    private static final int INIT_ITEMS = 8;
    private static final int INIT_NEXTFIRST = 0;
    private static final int INIT_NEXTLAST = 1;
    private static final int INIT_SIZE = 0;
    private static final int ENLARGE_RATE = 2000;
    private static final double SHRINK_RATE = 0.25;

    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    /* Create an empty array. */
    public ArrayDeque() {
        this.items = (T[]) new Object[INIT_ITEMS];
        this.nextFirst = INIT_NEXTFIRST;
        this.nextLast = INIT_NEXTLAST;
        this.size = INIT_SIZE;
    }

    /* Create an array with size. */
    public ArrayDeque(int s) {
        this.items = (T[]) new Object[s];
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
    }

    public void equal(ArrayDeque<T> p) {
        items = p.items;
        nextFirst = p.nextFirst;
        nextLast = p.nextLast;
        size = p.size;
    }

    /* Should process the array. Using in add items. */
    // System.arraycopy
    public void enlargeArray() {
        if (size != 0) {
            if (size == items.length) {
                ArrayDeque<T> p = new ArrayDeque<>(size * ENLARGE_RATE);
                int length = size; // For fix size
                for (int i = 0; i < length; i++) {
                    p.addLast(items[getFirst()]);
                    removeFirst();
                }
//                T[] p = (T[]) new Object[size * 2];
//                System.arraycopy(items, 0, p, 0, size);
                equal(p);
            }
        }
    }

    /* Should process the array. Using in remove items. */
    public void shrinkArray() {
        if (size != 0) {
            if (items.length >= 16 && size <= Math.round(items.length * SHRINK_RATE)) {
                ArrayDeque<T> p = new ArrayDeque<>((int)Math.round(items.length * SHRINK_RATE));
                int length = size;
                for (int i = 0; i < length; i++) {
                    p.addLast(items[getFirst()]);
                    // remove items first
                    // so ugly so bad, not elegant at all
                    size -= 1;
                    int first;
                    if (nextFirst == items.length - 1) {
                        first = 0;
                    } else {
                        first = nextFirst + 1;
                    }
                    T firstItem = items[first];
                    items[first] = null;
                    nextFirst = first;
                }
//                T[] p = (T[]) new Object[items.length / 4];
//                System.arraycopy(items, 0, p, 0, size);
                equal(p);
            }
        }
    }

    public void addFirst(T item) {
        enlargeArray();
        items[nextFirst] = item;
        if (nextFirst - 1 >= 0) {
            nextFirst -= 1;
        } else {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size != 0) {
            if (size == items.length) {
                enlargeArray();
            }
        }
        items[nextLast] = item;
        if (nextLast + 1 < items.length) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        int index = first;
        for (int i = 0; i < items.length; i++) {
            if (index < items.length) {
                System.out.println(items[index]);
                index += 1;
            } else {
                System.out.println(0);
                index = 0;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
        }
        int first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        T firstItem = items[first];
        items[first] = null;
        nextFirst = first;
        shrinkArray();
        return firstItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
        }
        int last;
        if (nextLast == 0) {
            last = items.length - 1;
        } else {
            last = nextLast - 1;
        }
        T lastItem = items[last];
        items[last] = null;
        nextLast = last;
        shrinkArray();
        return lastItem;
    }

    /* The first index is zero. */
    public T get(int index) {
        int first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        if (index + first < items.length) {
            return items[index + first];
        } else {
            return items[index + first - items.length];
        }
    }

    /* Return the index of first. */
    public int getFirst() {
        int first;
        if (nextFirst == items.length - 1) {
            return 0;
        } else {
            return nextFirst + 1;
        }
    }

    // TODO: Two special methods
}
