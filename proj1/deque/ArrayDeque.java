package deque;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    /* Create an empty array. */
    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
    }

    /* Create an array with size. */
    public ArrayDeque(int s) {
        this.items = (T[]) new Object[s];
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
    }

    /* Should process the array. Using in add items. */
    // System.arraycopy
    public void enlargeArray() {
        if (size != 0) {
            if (size == items.length) {
                ArrayDeque<T> p = new ArrayDeque<>(size * 2);
                int length = size; // For fix size
//                T[] p = (T[]) new Object[size * 2];
                for (int i = 0; i < length; i++) {
                    p.addLast(items[getFirst()]);
                    removeFirst();
                }
//                System.arraycopy(items, 0, p, 0, size);
                items = p.items;
                nextFirst = p.nextFirst;
                nextLast = p.nextLast;
                size = p.size;
            }
        }
    }

    /* Should process the array. Using in remove items. */
    public void shrinkArray() {
        if (size != 0) {
            if (items.length >= 16 && size <= Math.round(items.length / 4.0)) {
                ArrayDeque<T> p = new ArrayDeque<>(Math.round(items.length / 4));
                int length = size;
                for(int i = 0; i < length; i++){
                    p.addLast(items[getFirst()]);
                    removeFirst();
                }
//                T[] p = (T[]) new Object[items.length / 4];
//                System.arraycopy(items, 0, p, 0, size);
                items = p.items;
                nextFirst = p.nextFirst;
                nextLast = p.nextLast;
                size = p.size;
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