package DSA.LinkedList;

public class MiddleOfLL {
    //Brute Force
    public ListNode middleNode(ListNode head) {
        //Brute Force
        int len = 0;
        ListNode itr = head;
        while(itr != null){
            len++;
            itr = itr.next;
        }
        int mid = len/2;
        int cnt = 0;
        itr = head;
        while(cnt < mid){
            itr = itr.next;
            cnt++;
        }
        return itr;
    }



    //Optimal Approach - Using Slow & Fast Pointers
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
