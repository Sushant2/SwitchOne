//Write a program to return the head of doubly linkedlist after reversing it

//Brute Force - swap data
//can do using 2 ptrs head & tail
//also can do using stack

public class ReverseADLL
{
    public static Node reverseDLL(Node head)
    {
        //Brute Force
        //using stack
        Stack<Integer> stk = new Stack<>();
        Node itr = head;
        while(itr != null){
            stk.push(itr.data);
            itr = itr.next;
        }
        itr = head;
        while(itr != null){
            itr.data = stk.pop();
            itr = itr.next;
        }
        return head;
    }
}

//time compl - O(2n)
//space compl - O(1)


//Optimal Appproach
//we need to solve this in 1 traversal
//we will swap the pointers prev & next for a node

//USE the strategy of swapping 2 varibles
//take and example of 1 node at first & swap its prev & next

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        //Optimal Approach
        //using 1 traversal
        //store the prev pointer in temp
        if(head == null || head.next == null)
            return head;

        Node temp = null; //head.prev initially
        Node curr = head;
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            //as we're changing the pointers , now we'll move to curr = curr.prev instead of next
            curr = curr.prev;
        }
        return temp.prev;
    }
}

//time compl - O(n)
//space compl - O(1)