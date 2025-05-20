//write a program to check if a linked list is palindrome or not

//Brute Force

public boolean checkPalindrome(ListNode head){
    //Brute Force
    ArrayList<Integer> list = new ArrayList<>();
    ListNode temp = head;
    while(temp != null){
        list.add(temp.val);
        temp = temp.next;
    }
    //now take 2 pointers i, j
    int i = 0, j = list.size()-1;
    while(i <= j){
        if(list.get(i) != list.get(j))
            return false;
        i++;
        j--;
    }
return true;
}

//time compl - O(n)
//space compl - O(n)

//Optimised
//Step1 findMiddle node using slow & fast
//step2 reverse second half(inplace)
//step3 check palindrome

class Solution {

    public ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) //even length case
            return prev;
        return slow;
    }

    public ListNode reverseHead(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        //Step1 findMiddle node using slow & fast
        //step2 reverse second half(inplace)
        //step3 check palindrome
        ListNode middleNode = findMiddleNode(head);
        ListNode reverseHead = reverseHead(middleNode.next); 
        while(reverseHead != null){
            if(reverseHead.val != head.val)
                return false;
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }
}

//time compl - O(n) + O(n) + O(n)
//space compl - O(1)