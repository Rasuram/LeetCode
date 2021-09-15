package allexamples;



public class AddTwoNodes {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode li = new ListNode(0);
        if (l1 != null && l2 != null) {
            int s1 = Integer.parseInt(getSum(l1));
            int s2 = Integer.parseInt(getSum(l2));
            int result = s1 + s2;
            while (result > 0) {
                int temp = result % 10;
                result = result / 10;
                li = insertAfter(li, temp);
            }
        }
        return li.next;
    }

    public String getSum(ListNode l1) {
        StringBuffer str = new StringBuffer();
        while (l1 != null) {
            str.append(l1.val);
            l1 = l1.next;
        }

        return str.reverse().toString();
    }

    public ListNode insertAfter(ListNode head, int value) {
        if (head == null) {
            head = new ListNode(value);
        } else {
            head.next = insertAfter(head.next, value);
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(("abc".split("")));
        ListNode l = new ListNode(2);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(4);
        AddTwoNodes ad = new AddTwoNodes();
        System.out.println(ad.addTwoNumbers(l, l1));

    }
}
