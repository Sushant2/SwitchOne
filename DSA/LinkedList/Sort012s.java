//write a program to sort the linklist, containing 0s, 1s, 2s only

//Brute Force
//take 3 counter variables 0,1,2
//replace data in list
//2 pass solution
//time compl - O(2n)
//space compl - O(1)


//Optimal Approach
public class Sort012s {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null)
                return head;
            ListNode head0 = new ListNode(-1);
            ListNode head1 = new ListNode(-1);
            ListNode head2 = new ListNode(-1);
            ListNode zero = head0, one = head1, two = head2;
            ListNode temp = head;
            while(temp!=null){
                if(temp.val == 0){
                    zero.next = temp;
                    zero = zero.next;
                }else if(temp.val == 1){
                    one.next = temp;
                    one = one.next;
                }else if(temp.val == 2){
                    two.next = temp;
                    two = two.next;
                }
                temp = temp.next;
            }
            zero.next = (head1.next)? head1.next : head2.next;
            one.next = head2.next;
            two.next = null;
            return zero.next;
    }    
}


//time compl - O(n)
//space compl - O(1)