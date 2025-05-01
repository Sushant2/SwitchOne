//write a program to find the length of loop in singly linked list

//Brute Force
//Using hashing & finding length in the same iteration by taking a ctr

import java.util.HashMap;

public int countNodesinLoop(Node head) {
    if(head == null || head.next == null){
        return 0;
    }
    
    HashMap<Node, Integer> map = new HashMap<>();
    Node temp = head;
    int ctr = 0;
    while(temp != null){
        if(map.containsKey(temp)){
            return (ctr - map.get(temp));
        }
        map.put(temp, ctr++);
        temp = temp.next;
    }
    return 0;
}

//time compl - O(n) + O(1) - get/put/containsKey
//space compl - O(n)

//Otimised Apporoach
//detect the loop in list & from the collision point, if we iterate again in cycle, we'll end up at the collision point only

public int countNodesinLoop(Node head) {
    if(head == null || head.next == null){
        return 0;
    }
    
    Node slow = head, fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return getLengthOfLoop(slow, fast);
        }
    }
    return 0;
}

public int getLengthOfLoop(Node slow, Node fast){
    int len = 1; //atleast 1 node in cycle
    fast = fast.next;
    while(fast!=slow){
        len++;
        fast = fast.next;
    }
    return len;
}

//time compl - O(2*n)
//space compl - O(1)