//remove duplicates from sorted doubly linked list

//the same solution will work for : Remove duplicates from single linked list
//just remove the line where we're assigning prev pointer
public class RemoveDuplicatesFromDLL {
    public static Node uniqueSortedList(Node head) {
        if(head == null || head.next == null)
            return head;
        Node temp = head.next, curr = head;
        while(temp != null){
            //skip duplicate nodes
            while(temp != null && curr.data == temp.data){
                temp = temp.next;
            }

            curr.next = temp;
            if(temp != null)
                temp.prev = curr;
            
            if(temp == null)
                return head;

            curr = temp;
            temp = temp.next;
        }
        return head;
    }
}


//time compl - O(n)
//space compl - O(1)