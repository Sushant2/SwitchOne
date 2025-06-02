//write a program to construct a linked list clone(deep copy), and assign next & random pointers same as in original list

import java.util.HashMap;

public class CloneLLWithNextAndRandomPTr {
        public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        //Brute Force
        //using hashMap
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        //assign next & random pointer
        Node dummy = new Node(-1);
        temp = head;
        while(temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}


//time compl - O(n) + O(n)
//space compl - O(n)