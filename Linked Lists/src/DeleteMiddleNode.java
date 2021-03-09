public class DeleteMiddleNode {
    static ListNode head;

    public static void main(String[] args) {
        //adding elements
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Before Deletion :");
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        deletion(head.next.next);
        System.out.println("After Deletion :");
        temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static void deletion(ListNode head) {
        if(head==null)
            return ;
        ListNode temp = head.next;
        head.data = temp.data;
        head.next = temp.next;
    }
}
