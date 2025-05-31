//reverse the nodes in k group in linked list

public class ReverseNodesInKGroups {
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1)
            return head;
        
        ListNode temp = head;
        ListNode kNode = head;
        ListNode prevNode = null, nextNode = null;
        while(temp != null){
            //for each group
            int cnt = k;
            kNode = temp;
            while(kNode != null && cnt > 1){
                kNode = kNode.next;
                cnt--;
            }
            if(kNode != null){
                nextNode = kNode.next;
                kNode.next = null;

                ListNode newHead = reverse(temp);

                //first group
                if(head == temp){
                    head = newHead;
                }else{
                    prevNode.next = newHead;
                }

                prevNode = temp;
                temp = nextNode;
            }else{
                if(prevNode != null){
                    prevNode.next = temp;
                    break;
                }
            }
        }
        return head;
    }
}

//time compl - O(n)
//space compl - O(1)