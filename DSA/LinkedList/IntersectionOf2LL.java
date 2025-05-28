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

//Better Approach
//2 pointers, initially both pointers are not at same level, as the length of both list is diff.
//so first, skip the nodes of bigger list, to be at same level(find len, & skip nodes)
//move both pointers by one & return intersection point
//no extra space

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //base case
        if(headA == null || headB == null)
            return null;
        
        int lenA = findLen(headA);
        int lenB = findLen(headB);
        
        int diff = (lenA > lenB) ? lenA - lenB : lenB - lenA;
        ListNode tempA = headA, tempB = headB;
        //skip the nodes of bigger list
        if(lenA > lenB){
            while(diff > 0){
                tempA = tempA.next;
                diff--;
            }
        }else{
            while(diff > 0){
                tempB = tempB.next;
                diff--;
            }
        }

        //now both nodes are at same level, move both by one
        while(tempA != null && tempB != null){
            if(tempA == tempB)
                return tempA;
            
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    public int findLen(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}

//time compl - O(3n)
//space compl - O(1)

//Optimal Approach
//take 2 pointers, both keep searching each other until they meet(at a node or null)
//if a pointers reaches null first & can't find the other node, it'll chhange the path of search(reinitialise with opposite head)
//similary other another node will do the same

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //base case
    if(headA == null || headB == null)
        return null;
    //take 2 pointers
    ListNode tempA = headA, tempB = headB;

    //keeping searching until they point to the same node
    while(tempA != tempB){
        tempA = tempA.next;
        tempB = tempB.next;
        if(tempA == tempB){
            return tempA;
        }
        if(tempA == null)
            tempA = headB;
        if(tempB  == null)
            tempB = headA;
    }
    //when first node itself is intersection point(so it'll no go inside while loop)
    return tempA;
}

//time compl - O(n+m)
//space compl - O(1)