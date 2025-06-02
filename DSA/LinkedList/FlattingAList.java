import java.util.ArrayList;
import java.util.Collections;

public class FlattingAList {
    Node flatten(Node root) {
        // Brute Force
        if(root == null || root.next == null)
            return root;
        
        //traverse and store in a list
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = root;
        while(root != null){
            list.add(root.data);
            if(root.bottom != null){
                Node tempChild = root.bottom;
                while(tempChild != null){
                    list.add(tempChild.data);
                    tempChild = tempChild.bottom;
                }
            }
            root = root.next;
        }
        
        //sort the list
        Collections.sort(list);
        
        //create a new linkedlist
        Node dummy = new Node(-1);
        Node res = dummy;
        for(int i = 0;i<list.size();i++){
            Node node = new Node(list.get(i));
            res.bottom = node;
            res = node;
        }
        return dummy.bottom;
    }
}

//time compl - O(m*n) + O(mlogn) + O(m+n)
//space compl - (2*(m+n))

//Optimal
//take 2 list only & try to merge them first, use 2 pointers(same as in merge sort)
//now to complete merge, use recursion & merge while returning

Node flatten(Node root) {
    // Brute Force
    if(root == null || root.next == null)
        return root;
    
    Node mergedNode = flatten(root.next);
    return merge2List(root, mergedNode);
}

public Node merge2List(Node l1, Node l2){
    Node dummy = new Node(-1);
    Node res = dummy;
    while(l1 != null && l2 != null){
        if(l1.data < l2.data){
            res.bottom = l1;
            res = l1;
            l1 = l1.bottom;
        }else{
            res.bottom = l2;
            res = l2;
            l2 = l2.bottom;
        }
        res.next = null;
    }
    if(l1 != null)
        res.bottom = l1;
    if(l2 != null)
        res.bottom = l2;
        
    return dummy.bottom;
}

//time compl - O(2(m*n))
//space compl - O(n)