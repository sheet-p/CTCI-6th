public class Partition {
    static ListNode head;

    public static void main(String[] args) {
        //adding elements
        head = new ListNode(6);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println("Before Partition :");
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        ListNode newHead = partitionK(head, 5);
        System.out.println("After Partition :");
        temp = newHead;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static ListNode partitionK(ListNode head, int k) {
        ListNode lesser = new ListNode(0);
        ListNode finalResult = lesser;
        ListNode greater = new ListNode(0);
        ListNode result = greater;


        while(head != null) {
            if(head.data < k) {
                finalResult.next = new ListNode(head.data);
                finalResult = finalResult.next;
            }
            else {
                result.next = new ListNode(head.data);
                result = result.next;
            }

            head = head.next;
        }

        finalResult.next = greater.next;

        return lesser.next;
    }
}
