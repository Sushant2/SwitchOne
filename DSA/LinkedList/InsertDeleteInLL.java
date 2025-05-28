package DSA.LinkedList;

public class InsertDeleteInLL {

    public static Node deleteHead(Node head){
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        //iterate till tail.next
        //edge case
        if(head == null || head.next == null)
            return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteKtNode(Node head, int k){
        if(k == 1)
            return head.next;
        if(head == null)
            return head;

        Node itr = head, prev = null;
        int cnt = 0;
        while(itr != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
            }
            prev = itr;
            itr = itr.next;
        }
        return head;
    }


    public static Node deleteEle(Node head, int k){
        if(head == null)
            return head;
        //if k is first ele
        if(head.val == k)
            return head.next;

        Node itr = head, prev = null;
        while(itr != null){
            if(itr.val == k){
                prev.next = prev.next.next;
            }
            prev = itr;
            itr = itr.next;
        }
        return head;
    }

    public static Node insertHead(Node head, int val){
        return new Node(val, head);
    }

    public static Node insertTail(Node head, int val){
        //itrerate till end of ll
        if(head == null){
            return new Node(val);
        }
        Node itr = head;
        while(itr.next != null){
            itr = itr.next;;
        }
        Node temp = new Node(val);
        itr.next = temp;
        return head;
    }

    public static Node insertAtKthPos(Node head, int val, int pos){
        //edge case
        if(head == null){
            if(pos == 1)
                return new Node(val, head);
            else
                return null;
        }
        if(pos == 1)
            return new Node(val, head);

        //for pos >= 2
        Node itr = head, prev = null;
        int cnt = 0;
        while (itr != null) {
            cnt++;
            if(cnt == pos){
                Node temp = new Node(val);
                temp.next = itr;
                prev.next = temp;
            }
            prev = itr;
            itr = itr.next;
        }

        return head;
    }

    public static Node insertKVal(Node head, int k, int val){
        //edge case - head is null/empty ll, nothing to match
        if(head == null)
            return null;
        
        //matched with 1st ele
        if(head.val == k)
            return new Node(val, head);

        //for pos >= 2
        Node itr = head, prev = null;
        while (itr != null) {
            if(itr.val == k){
                Node temp = new Node(val);
                temp.next = itr;
                prev.next = temp;
            }
            prev = itr;
            itr = itr.next;
        }

        return head;
    }




    public static void printList(Node head){
        Node itr = head;
        while(itr!=null){
            System.out.print(itr.val + " ");
            itr = itr.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        //creating a linked list out of arr
        Node head = new Node(arr[0]);
        Node itr = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            itr.next = temp;
            itr = itr.next;
        }

        //Delete head from linkedlist
        head = deleteHead(head);
        printList(head);
        System.out.println();
        //Delete tail from linkedlist
        head = deleteTail(head);
        printList(head);
        System.out.println();
        //Delete kth node from linkedlist
        head = deleteKtNode(head, 2);
        printList(head);
        System.out.println();
        //Delete an element from linkedlist
        head = deleteEle(head, 2);
        printList(head);
        System.out.println();

        //Insert at head
        head = insertHead(head, 100);
        printList(head);
        System.out.println();

        //Insert at tail
        head = insertTail(head, 200);
        printList(head);
        System.out.println();

        //Insert at kth position
        head = insertAtKthPos(head, 300, 4);
        printList(head);
        System.out.println();

        //Insert at kth value
        head = insertKVal(head, 200, 500);
        printList(head);
        System.out.println();
    }
}
