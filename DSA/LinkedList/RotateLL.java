//write a program to rotate the list by k nodes

//Approach
//Find len of list
// Find ttail of list
//traverse till len-k & temp is newHead
//connect tail'next to newHead

public class RotateLL {
    public int findLen(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode getTail(ListNode head){
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = findLen(head);
        ListNode tail = getTail(head);
        k = k % len;
        if(k == 0)
            return head;
        
        int goTo = len - k;
        ListNode prev = null, newHead = head;
        while(goTo > 0 && newHead != null){
            prev = newHead;
            newHead = newHead.next;
            goTo--;
        }

        prev.next = null;
        tail.next = head;
        return newHead;

    }
}
