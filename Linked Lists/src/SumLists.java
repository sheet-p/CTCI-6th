import java.util.Stack;

public class SumLists {
    static ListNode head1;
    static ListNode head2;

    public static void main(String[] args) {
        head1 = new ListNode(7);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(6);

        head2 = new ListNode(5);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(2);

        ListNode h = addTwoNumbers(head1, head2);
        while(h!=null) {
            System.out.println(h.data);
            h = h.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1, curr2;
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode addition;
        curr1 = l1;
        curr2 = l2;
        int counter=0, carry=0, sum=0;
        Stack<Integer> stack = new Stack<>();
        while(curr1 != null && curr2 != null) {
            sum = carry + curr1.data + curr2.data;
            if(sum >= 10) {
                carry = 1;
                stack.push(sum % 10);
            }
            else {
                carry = 0;
                stack.push(sum);
            }
            sum = 0;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null) {
            sum = carry + curr1.data;
            if(sum > 9) {
                carry = 1;
                stack.push(sum % 10);
            }
            else {
                carry = 0;
                stack.push(sum);
            }
            sum = 0;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            sum = carry + curr2.data;
            if(sum > 9) {
                carry = 1;
                stack.push(sum % 10);
            }
            else {
                carry = 0;
                stack.push(sum);
            }
            sum = 0;
            curr2 = curr2.next;
        }
        if(carry == 1) {
            stack.push(1);
            carry =0;
        }
        while(!stack.isEmpty()) {
            head.next = new ListNode(stack.pop() % 10);
            head = head.next;
        }
        addition = reverse(result.next);
        return addition;
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
