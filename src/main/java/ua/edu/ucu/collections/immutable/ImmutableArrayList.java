package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private int len = 0;
    private Object[] content;


    public ImmutableArrayList() {
        content = new Object[len];
    }

    public ImmutableArrayList(int wantedLen) {
        len = wantedLen;
        content = new Object[len];
    }

    public ImmutableArrayList add(Object el) {
        return add(len - 1, el);
    }

    public ImmutableArrayList add(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableArrayList newElem = new ImmutableArrayList(len + 1);
        if (index >= 0) {
            System.arraycopy(this.content, 0, newElem.content, 0, index);
        }
        newElem.content[index] = e;

        if (len - index + 1 >= 0) {
            System.arraycopy(this.content, index + 1, newElem.content,
                    index + 1, len - index + 1);
        }
        return newElem;
    }

    public ImmutableArrayList addAll(Object[] c) {
        return addAll(len - 1, c);
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableArrayList newElem = new ImmutableArrayList(len + c.length);
        if (index >= 0) {
            System.arraycopy(this.content, 0, newElem.content, 0, index);
        }

        if (c.length - index >= 0) {
            System.arraycopy(content, index, newElem.content, index,
                    c.length - index);
        }

        if (newElem.len - index + c.length >= 0) {
            System.arraycopy(content, index + c.length, newElem.content,
                    index + c.length, newElem.len - index + c.length);
        }
        return newElem;
    }

    public Object get(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return content[index];
    }

    public ImmutableArrayList remove(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableArrayList newElem = new ImmutableArrayList(len - 1);
        if (index >= 0) {
            System.arraycopy(this.content, 0, newElem.content, 0, index);
        }
        if (len - index + 1 >= 0) {
            System.arraycopy(content, index + 1, newElem.content,
                    index + 1, len - index + 1);
        }
        return newElem;
    }

    public ImmutableArrayList set(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableArrayList newElem = new ImmutableArrayList(len);
        if (index >= 0) {
            System.arraycopy(this.content, 0, newElem.content, 0, index);
        }

        newElem.content[index] = e;

//        for (int i = index + 1; i < len; i++){
//            newElem.content[i] = content[i];
//        }
        if (len - index + 1 >= 0) {
            System.arraycopy(content, index + 1, newElem.content,
                    index + 1, len - index + 1);
        }
        return newElem;
    }

    public int indexOf(Object e) {
        for (int i = 0; i < len; i++) {
            if (content[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return len;
    }

    public ImmutableArrayList clear() {
        content = new Object[0];
        len = 0;

        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public Object[] toArray() {
        return content;
    }

    public String toString() {
        return Arrays.toString(content);
    }
}
