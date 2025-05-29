
//BRUTE FORCE
//worked on int & long
//but doesn't work on number > long
public class Add1ToLL {
    public static long getNumber(Node head) {
        Node temp = head;
        long num = 0l;
        while (head != null) {
            num += head.data;
            if (head.next != null)
                num *= 10l;
            head = head.next;
        }
        return num;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public static Node addOne(Node head) {
        // Write your code here.
        long num = getNumber(head);
        num += 1l;

        Node dummy = new Node(-1);
        Node temp = dummy;
        while (num != 0l) {
            long rem = num % 10l;
            long quo = num / 10l;
            Node node = new Node((int) rem);
            temp.next = node;
            temp = temp.next;
            num = quo;
        }
        return reverse(dummy.next);
    }
}

//time compl - O(3n)
//space compl - O(n)

//Better Approach
//reverse the list(as we can't add in the tail directly)
//take carry as 1(initially, the number we need to add)
//reverse again & check if carry still 1, then return carryNode.next = ansList
public class Solution {

	public static Node reverse(Node head){
		Node prev = null;
		Node curr = head;
		while(curr != null){
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}

	public static Node addOne(Node head) {
		if(head == null)
			return head;
		// reverse list
		Node reverseHead = reverse(head);

		//initially as 1, cos we want to add 1 in list
		int carry = 1;
		Node temp = reverseHead;
		while(temp != null){
			int nodeData = temp.data;
			nodeData += carry;
			temp.data = nodeData%10;
			if(nodeData < 10){
				carry = 0;
				break;
			}
			temp = temp.next;
		}
		// reverse list again
		Node reverseHead2 = reverse(reverseHead);
		if(carry == 1){
			Node carryHead = new Node(carry, reverseHead2);
			return carryHead;
		}

		return reverseHead2;
	}
}

//time compl - O(3n)
//space compl - O(1)


//Optimal approach
//using recursion
//do the carry operation while returing from recurison
public class Solution {

	public static int addHelper(Node head){
		//base case
		if(head == null)
			return 1;
		int carry = addHelper(head.next);
		int val = head.data + carry;
		head.data = val%10;
		if(val < 10)
			return 0;
		return carry;
	}

	public static Node addOne(Node head) {
		if(head == null)
			return head;

		int carry = addHelper(head);
		
		if(carry == 1){
			Node carryHead = new Node(carry, head);
			return carryHead;
		}

		return head;
	}
}

//time compl - O(n);
//space compl - O(1)