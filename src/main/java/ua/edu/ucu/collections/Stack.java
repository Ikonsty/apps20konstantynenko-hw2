package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    private final ImmutableLinkedList content;

    public Stack() {
        content = new ImmutableLinkedList();
    }

    public Object peek() {
        if (content.getTail() == null){
            throw new ArrayIndexOutOfBoundsException("No peek is here");
        }
        return content.getTail();
    }

    public Object pop() {
        if (content.getTail() == null){
            throw new ArrayIndexOutOfBoundsException("No elements are here");
        }
        Object value = content.getTail();
        content.remove(content.getLen() - 1);
        return value;
    }

    public void push(Object e) {
        Node newNode = new Node(e);
        content.add(newNode);
    }
}