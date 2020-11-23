package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Queue {
    private ImmutableLinkedList content;

    public Queue() {
        content = new ImmutableLinkedList();
    }

    public Object peek() {
        return content.getHead();
    }

    public Object dequeue() {
        Object value = content.getHead();
        content.setHead(content.getHead().getNext());
        return value;
    }

    public void enqueue(Object e) {
        Node newNode = new Node(e);
        content.add(newNode);
    }
}
