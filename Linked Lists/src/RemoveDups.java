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

        System.out.println("With O(n) space :");
        ListNode newHead = removeDuplicates(head);
        while(newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

        //if temporary buffer not allowed
        System.out.println("With constant space and O(n2) time :");
        ListNode newnewHead = noTempBuffer(head);
        while(newnewHead != null) {
            System.out.println(newnewHead.data);
            newnewHead = newnewHead.next;
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

    private static ListNode noTempBuffer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!= null) {
            int val = slow.data;
            ListNode temp = slow.next;
            ListNode prev = null;
            //loop through all others to find if val exists
            while(temp != null) {
                if(temp.data == val) {
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
                else {
                    prev = temp;
                    temp = temp.next;
                }
            }
            slow = slow.next;
        }

        return head;
    }
}
