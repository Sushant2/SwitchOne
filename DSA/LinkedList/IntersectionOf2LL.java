//find Intersection of Two Linked Lists

import java.util.HashSet;
import java.util.Set;

//BruteForce
public class IntersectionOf2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //base case
        if(headA == null || headB == null)
            return null;
        
        Set<ListNode> list = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            list.add(temp);
            temp = temp.next;
        }
    
        temp = headB;
        while(temp != null){
            if(list.contains(temp))
                return temp;
            temp = temp.next;
        }
        return null;
    }
}

//time compl - O(2n)
//space compl - O(n)