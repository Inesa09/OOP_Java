package com.inesonjka;

public class LinkedList {
    Node start, end;

    public LinkedList() {
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        list.add(5);
        System.out.println(list.size());
        list.add(2);
        System.out.println(list.size());
        list.add(8);
        System.out.println(list.size());
        System.out.println("***");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("***");
        list.delete(0);
        System.out.println(list.size());
        list.delete(1);
        System.out.println(list.size());
        list.delete(0);
        System.out.println(list.size());
        list.add(5);
        System.out.println(list.size());
        list.add(2);
        System.out.println(list.size());
    }

    public void add(Integer data) {
        Node current = new Node();
        current.setData(data);
        if (end == null)
            start = current;
        else
            end.setNext(current);
        end = current;
    }

    public Integer get(int index) {
        if (this.size() <= index || index < 0)
            return null;
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean delete(int index) {
        if (this.size() <= index || index < 0)
            return false;
        if (index == 0) {
            start = start.getNext();
            if (start == null)
                end = null;
        } else {
            Node current = start;
            for (int i = 0; i < index-1; i++)
                current = current.getNext();
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null)
                end = current;
        }
        return true;
    }

    public int size() {
        if (start == null)
            return 0;
        Node current = start;
        int size = 1;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
}

class Node{
    private Node next;
    private Integer data;

    public Node() {
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Integer getData() {
        return data;
    }
    public void setData(Integer data) {
        this.data = data;
    }
}

