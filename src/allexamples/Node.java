package allexamples;

public class Node {
    int data;
    Node next;
    Node(int givenData){
        this.data = givenData;
    }


    public static int nodeList(Node head) {
        int counter = 0;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }


    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(5);
        Node c = new Node(6);

        a.next=b;
        b.next=c;
        System.out.println(nodeList(a));


    }






}
