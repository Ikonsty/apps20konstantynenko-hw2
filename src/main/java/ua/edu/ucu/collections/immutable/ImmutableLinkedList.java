package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {
    private Node Head;
    private Node Tail;
    private int len;

    public ImmutableLinkedList() {
        this.Head = null;
        this.Tail = null;
        this.len = 0;
    }

    public ImmutableLinkedList(Node node) {
        this.Head = node;
        this.Tail = node;
        this.len = 1;
    }

    public ImmutableLinkedList add(Object e) {
        return add(len - 1, e);
    }

    public ImmutableLinkedList add(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node added_node = new Node(e);
        // create new Hew for new list
        Node newHead = new Node(this.Head.getData());
        //create new list with this head
        ImmutableLinkedList new_lst = new ImmutableLinkedList(newHead);

        Node thisCurrNode = this.Head.getNext();
        Node newCurrNode = new_lst.Head;

        for (int i = 1; i < index; i++) {
            Node new_node = new Node(thisCurrNode.getData());
            newCurrNode.setNext(new_node);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            new_lst.len += 1;
        }

        newCurrNode.setNext(added_node); //add that node to new structure
//        added_node.setNext(thisCurrNode);//add next to added node
        newCurrNode = added_node;
        new_lst.len += 1;

        for (int i = index + 1; i < len; i++) {
            Node new_node = new Node(thisCurrNode.getData());
            newCurrNode.setNext(new_node);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            new_lst.len += 1;
        }
        new_lst.Tail = newCurrNode;
        return new_lst;
    }

    public ImmutableLinkedList addFirst(Object c) {
        return add(0, c);
    }


    public ImmutableList addAll(Object[] c) {
        return addAll(len - 1, c);
    }

    public ImmutableList addAll(int index, Object[] c) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableLinkedList new_lst = new ImmutableLinkedList();
        for (int i = index; i < index + c.length; i++) {
            new_lst = new_lst.add(i, c[i - index]);
        }
        return new_lst;
    }

    public Object get(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node currNode = this.Head;
        for (int i = 1; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    public Object getFirst() {
        return this.Head.getData();
    }

    public Object getLast() {
        return this.Tail.getData();
    }

    public ImmutableLinkedList remove(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // create new Hew for new list
        Node newHead = new Node(this.Head.getData());
        //create new list with this head
        ImmutableLinkedList new_lst = new ImmutableLinkedList(newHead);

        Node thisCurrNode = this.Head.getNext();
        Node newCurrNode = new_lst.Head;

        for (int i = 1; i < index; i++) {
            Node new_node = new Node(thisCurrNode.getData());
            newCurrNode.setNext(new_node);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            new_lst.len += 1;
        }
        for (int i = index + 1; i < len; i++) {
            Node new_node = new Node(thisCurrNode.getData());
            newCurrNode.setNext(new_node);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            new_lst.len += 1;
        }
        new_lst.Tail = newCurrNode;
        return new_lst;
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableLinkedList delList = remove(index);
        ImmutableLinkedList new_lst = delList.add(index, e);
        return new_lst;
    }

    public int indexOf(Object e) {
        Node currNode = this.Head;
        int index = 0;
        for (int i = 1; i < this.len; i++) {
            if (currNode.getData() == e) {
                return index;
            }
            index += 1;
            currNode = currNode.getNext();
        }
        return -1;
    }

    public int size() {
        return len;
    }

    public ImmutableLinkedList clear() {
        this.Head = null;
        this.Tail = null;
        this.len = 0;
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public Object[] toArray() {
        Object[] realList = new Object[this.len];
        Node currNode = this.Head;

        for (int i = 1; i < this.len; i++) {
            realList[i] = currNode.getData();
            currNode = currNode.getNext();
        }
        return realList;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public Node getHead() {
        return this.Head;
    }

    public Node getTail() {
        return this.Tail;
    }

    public void setHead(Node head) {
        this.Head = head;
    }

    public void setTail(Node tail) {
        this.Tail = tail;
    }

    public int getLen() {
        return this.len;
    }
}
