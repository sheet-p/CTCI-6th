public class ReturnKthToLast {
    static ListNode head;

    public static void main(String[] args) {
        //adding elements
        head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        //recursive approach
        int k = 3;
        System.out.println(k + "th to last Node is : " + recursiveKth(head, k));

        //approach 2
        kthToLast(head, k);
    }

    private static int recursiveKth(ListNode head, int k) {
        if(head == null)
            return 0;

        int index = recursiveKth(head.next, k) + 1;

        if(index == k)
            return head.data;

        return index;
    }

    private static void kthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        for(int i=0; i<k; i++) {
            if(p1 != null)
                p1 = p1.next;
            else
                System.exit(0);
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //answer is - return p2;
    }
}
