package linkedlist;

public class DoublyLinkedList {

    //Initially, head and tail is set to null
    ListNode head, tail = null;


    static public class ListNode {

        int data;
        ListNode prev;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }


    public void pushBefore(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            newNode.prev = null;
        } else {
            head.next = newNode;
            newNode.prev = head;
        }
        head = newNode;
    }

    public void pushAfter(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            newNode.prev = null;
            head = newNode;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = newNode;
            newNode.prev = head;
        }
    }


    public void insertNode(int nodeData) {
        ListNode node = new ListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }

    //add a node to the list
    public void addNode(int item) {
        //Create a new node
        ListNode newNode = new ListNode(item);
        //if list is empty, head and tail points to newNode
        if (head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.prev = null;
            //tail's next will be null
        } else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.prev = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
        }
        tail.next = null;
    }

    public ListNode addInMiddle(ListNode node, int data) {
        ListNode prev = node;
        int size = getSize(node);
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            prev = node;
            node = node.next;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next = newNode;
        newNode.next.prev = newNode;
        return node;
    }

    public ListNode sortInsert(ListNode node, int data) {

        ListNode new_node = new ListNode(data);
        ListNode current = node;
        ListNode prev = null;
        if (data < current.data) {
            new_node.next = current;
            new_node.prev = null;
            current.prev = new_node;
            return new_node;
        }
        while (current != null && current.data < data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            new_node.prev = prev;
            new_node.next = null;
            prev.next = new_node;
        } else {
            new_node.prev = prev;
            new_node.next = prev.next;
            prev.next = new_node;
            new_node.next.prev = new_node;

        }
        return head;
    }


    ListNode reverse(ListNode node) {

        if (node == null) return null;

        ListNode temp = node.next;
        node.next = node.prev;
        node.prev = temp;

        if (node.prev == null) {
            return node;
        }
        return reverse(node.prev);

    }


    private int getSize(ListNode node) {
        ListNode temp = node;
        int counter = 0;
        while (temp.next != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public void display(ListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.pushBefore(1);
        list.pushBefore(2);
        list.pushBefore(3);
        list.pushBefore(4);
        list.pushBefore(5);
        list.pushBefore(6);
        System.out.println(list.head);
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.pushAfter(1);
        list1.pushAfter(2);
        list1.pushAfter(3);
        list1.pushAfter(4);
        list1.pushAfter(5);
        list1.pushAfter(6);
        System.out.println(list1.head);

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertNode(1);
        list2.insertNode(2);
        list2.insertNode(3);
        list2.insertNode(4);
        list2.insertNode(5);
        list2.insertNode(6);
        // System.out.println(list1.head);
        list2.display(list2.head);
        list2.display(list2.reverse(list2.head));
      //  ListNode listnode = list2.addInMiddle(list2.head, 10);
      //  list2.display(listnode);


        // ListNode sortedNode = list2.sortInsert(list2.head, 10);
        //  list2.display(sortedNode);


 /*       allexamples.Node head = new allexamples.Node(1);
        head.next = new allexamples.Node(2);
        head.prev = null;

        head.next.next = new allexamples.Node(3);
        head.next.prev =  head.next;*/


    }
}
