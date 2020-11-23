package ua.edu.ucu.collections.immutable;

public class Node {
    private Object data;
    private Node next;
    public Node(Object data){
        this.next = null;
        this.data = data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public Object getData(){
        return this.data;
    }
}
