//Write a program to sort the given linkedlist in ascending order

//Brute Force
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        int i = 0;
         while(temp != null){
            temp.val = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}

//time compl - O(2n) + O(nlogn)
//space compl - O(n)

//Optimal
//uses merge sort technique
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        //find middle
        ListNode mid = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        //separate first & second half
        mid.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge2List(leftHead, rightHead);
    }

    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //as we want one node before in case of even, but ill work for odd case as well
        //so doing 1 step already for fast
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

public ListNode merge2List(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }
        if(head1!=null)
            temp.next = head1;
        else
            temp.next = head2;

        return dummy.next;
    }
}

//time compl = O(nlogn)
//space compl - O(1)