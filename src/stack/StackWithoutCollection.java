package stack;

import java.util.Stack;

public class StackWithoutCollection<T> {

    private Node top = null;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {

        Node oldTop = top;
        top = new Node(data);
        top.next = oldTop;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T v = top.data;
        top = top.next;
        return v;
    }

    T getNthElement(int index) {

        Node head = top;
        int count = 1;
        while (head != null) {
            if (count == index) {
                return head.data;
            }
            count++;
            head = head.next;
        }
        return null;
    }


    void printNodes() {
        Stack stack = new Stack();
        Node current = top;
        while (current != null) {
            System.out.println("elements==>" + current.data);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        StackWithoutCollection s = new StackWithoutCollection();
        s.push(10);//5
        s.push(20);//4
        s.push(30);//3
        s.push(40);//2
        s.push(50);//1
        s.printNodes();
        System.out.println();
        System.out.println(s.getNthElement(5));


    }

}
