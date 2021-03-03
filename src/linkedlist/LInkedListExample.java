package linkedlist;

public class LInkedListExample {

    private static Node head;


    void push(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }


    public static void main(String[] args) {
        LInkedListExample lInkedListExample = new LInkedListExample();
        for (int i = 5; i > 0; --i) {
            lInkedListExample.push(i);
            lInkedListExample.printList();
            lInkedListExample.printMiddle1(head);
        }
        lInkedListExample.deleteNode(3);

         char count[] = new char[256];
        count['c']++;
        count['d']++;
        System.out.println(isPrime(4));

    }


    public static int isPrime(long n) {
        // Write your code here
        if(n == 2){
            return 1;
        }
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                return i;
            }
        }
        return 1;
    }



    void printMiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;

        if (head != null) {
            while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }


    private void deleteNode(int key) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            printList();
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("allexamples.Node not found");
        }
        prev.next = temp.next;
        printList();
    }




    void printMiddle1(Node head) {

        Node mid = head;
        int counter = 0;
        while (head != null) {
            if (counter % 2 == 1) {
                mid = mid.next;
            }
            ++counter;
            head = head.next;
        }
        if (mid != null)
            System.out.println("The middle element is [" +
                    mid.data + "] \n");
    }

    private void printList() {

        Node tnode = head;
        while (tnode != null) {
            System.out.println(tnode.data + "-->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }



}
