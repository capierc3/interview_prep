package com.company;

public class Node {

    Node next = null;
    Object data = null;

    public Node(Object data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}
