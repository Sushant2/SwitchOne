//revsere a single linked list both ways - iterative & recursive approach

package DSA.LinkedList;

public class ReverseALL {
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    //time compl - O(n)
    //space compl - O(1)

    //Recursive approach
    public ListNode reverseList(ListNode head) {
        //recursive
        //base case
        if(head == null || head.next == null)
            return head;
        //Sorter problem
        ListNode newHead = reverseList(head.next);
        ListNode ahead = head.next;
        ahead.next = head;
        head.next = null;
        return newHead;
    }

    //time compl - O(n)
    //space compl - O(n) - stack space
}
