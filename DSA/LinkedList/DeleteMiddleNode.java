// You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

public ListNode deleteMiddle(ListNode head) {
    if(head == null || head.next == null)
        return null;
    ListNode slow = head, fast = head;
    ListNode prev = null;
    while(fast != null && fast.next != null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = prev.next.next;
    return head;
}

//time compl - O(n)
//space compl - O(1)