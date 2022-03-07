public class Palindrome {
    public static class Result {
        ListNode node;
        boolean result;
        Result(ListNode n, boolean res) {
            this.node = n;
            this.result = res;
        }
    }

    static ListNode head;

    public static void main(String[] args) {
        //adding elements
        head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);

        if(isPalindrome(head))
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static boolean isPalindrome(ListNode head) {
        int len = length(head);
        Result res = isPalrecur(head, len);
        return res.result;
    }

    private static int length(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private static Result isPalrecur(ListNode head, int length) {
        //even number of nodes
        if(head==null || length<=0)
            return new Result(head, true);
        //odd number of nodes
        if(length==1) {
            return new Result(head.next, true);
        }

        Result res = isPalrecur(head.next, length-2);

        if(!res.result || res==null)
            return res;

        res.result = (head.data == res.node.data);
        res.node = res.node.next;

        return res;
    }
}
