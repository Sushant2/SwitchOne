//Write a program to add 2 linked list & return the list of sum of them

//do the old school thing
//2 pointers & dummy node//sum & take carry
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        int carry = 0;
        ListNode temp1 = l1, temp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(temp1 != null || temp2 != null){
            int num1 = 0, num2 = 0;
            if(temp1 != null)
                num1 = temp1.val;
            if(temp2 != null)
                num2 = temp2.val;
            
            int sum = num1 + num2 + carry;
            int rem = rem = sum%10;
            carry = sum/10;
            ListNode node = new ListNode(rem);
            curr.next = node;
            curr = curr.next;

            if(temp1 != null)
                temp1 = temp1.next;
            if(temp2 != null)
                temp2 = temp2.next;
        }
        if(carry != 0){
            ListNode carryNode = new ListNode(carry);
            curr.next = carryNode;
        }
        return dummy.next;
    }
}

//time compl - O(n)
//space compl - O(n)