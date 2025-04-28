//wrrite a code to return the starting point of a loop/cycle in ll

//Brute force
public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null)
        return null;
    ListNode temp = head;
    Set<ListNode> set = new HashSet<>();
    while(temp != null){
        if(set.contains(temp))
            return temp;
        set.add(temp);
        temp = temp.next;
    }
    return null;
}

//time compl - O(n)
//space compl - O(1)

//better approach
public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null)
        return null;
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
        return slow;
        }
    }
    return null;
}

//time compl - O(n)
//space compl - O(1)