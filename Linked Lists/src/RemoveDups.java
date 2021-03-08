import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDups {
    static ListNode head;
    public static void main(String[] args) {

        //adding elements
        head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        ListNode newHead = removeDuplicates(head);

        while(newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }

    private static ListNode removeDuplicates(ListNode head) {
        //for checking duplicates
        Set<Integer> temp = new HashSet<>();

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if(temp.contains(curr.data)) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            }
            else {
                temp.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}
