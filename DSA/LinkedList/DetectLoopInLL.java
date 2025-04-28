//write a program to detect a loop in linkedlist

//Brute Force 

import java.util.HashSet;
import java.util.Set;

public boolean hasCycle(ListNode head) {
    //Brute Force
    Set<ListNode> set = new HashSet<>();
    ListNode temp = head;
    while(temp != null){
        if(set.contains(temp)){
            return true;
        }
        set.add(temp);
        temp = temp.next;
    }
    return false;
}

//time compl - O(n)
//space compl - O(n)

//Better Approach
public boolean hasCycle(ListNode head) {
ListNode slow = head, fast = head;
while(fast !=null && fast.next!= null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast)    
        return true;
}
return false;
}

//time compl - O(n)
//space compl - O(1)