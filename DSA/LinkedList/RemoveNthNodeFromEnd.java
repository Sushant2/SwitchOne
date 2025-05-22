//Given the head of a linked list, remove the nth node from the end of the list and return its head

//Using recursion
class Solution {
    int cnt = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        removeNode(dummy, n);
        return dummy.next;
    }

    public void removeNode(ListNode node, int n){
        //base case
        if(node == null)
            return;
        removeNode(node.next, n);
        cnt++;
        if(cnt == n+1)
            node.next = node.next.next;
    }
}

//time compl - O(n)
//space compl - O(1)

// Brute Force
//find length of list
//goto len - nth node
//remove it


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        //edge case
        if(n == len)
            return head.next;

        n = len - n;
        temp = head;
        while(temp != null){
            n--;
            if(n==0)
                break;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}

//time compl - O(2n) ~ O(n)
//space compl - O(1)

//optimal
//using 2 pointers, with gap of n
public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)
        return head;
    ListNode slow = head, fast = head;
    //create a gap of n
    for(int i = 1;i<=n;i++)
        fast = fast.next;
    //edge case when n equals length of list, means removing the first node
    if(fast == null)
        return head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next;
    }
    if(slow != null && slow.next != null)
        slow.next = slow.next.next;
    return head;
}

//time compl - O(n)
//space compl - O(1)
