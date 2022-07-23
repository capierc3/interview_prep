package com.company;

import java.util.LinkedList;

public class linkedLists {

    public static Node getNthToLast(int n, Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {

        Node head = new Node(0);
        head.setNext(new Node(1));
        Node temp = head.next;
        for (int i = 2; i < 20; i++) {
            temp.setNext(new Node(i));
            temp = temp.next;
        }

        Node el = getNthToLast(3, head);
        System.out.println(el.data);
    }

}
