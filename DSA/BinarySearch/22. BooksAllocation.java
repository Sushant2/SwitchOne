//program to allocate books to m students such that the maximum no.of pages allocated to a student is as minimum as possible
//books[i] = no. of pages ith book has
//each student should get atleast 1 book
//each book should be allocated to only one student, means same book can't get assined to more then 1 student
//book allocations should be in contagious manner


//APPROACH
//try with to allocate with 1 page, 2 page... but this no. of pages won't lead to allocation to anybook
//so i need atleast max(Arr) no of pages to assign book
//now keep assign the current book to student 1, and check can i assign the next book also to the current student if it stills less than my currMaxPages
//if not, so that means, now i need another student who can take this book with this no of pages

//BRUTE FORCE
import java.util.ArrayList;
public class Solution {
    public static boolean checkPossible(int pages, ArrayList<Integer> books, int m){
        int currStud = 1, currPages = 0;
        for(int i = 0;i<books.size();i++){
            if(currPages + books.get(i) <= pages){
                currPages += books.get(i);
            }else{
                currPages = books.get(i);
                currStud++;
            }

            if(currStud > m)
                return false;
        }
        return true;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        //edge case, when no of students are more than no of book, we can't assign each book to each student
        if(m > n)
            return -1;
        
        int low = Integer.MIN_VALUE, high = 0;
        for(int i = 0;i<arr.size();i++){
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }

        for(int pages = low;pages <= high;pages++){
            if(checkPossible(pages, arr, m))
                return pages;
        }
        return low;
    }
}

//time compl - O(maxArr-sumArr)*O(n)
//space compl - O(1)


import java.util.ArrayList;
public class Solution {
    public static boolean checkPossible(int pages, ArrayList<Integer> books, int m){
        int currStud = 1, currPages = 0;
        for(int i = 0;i<books.size();i++){
            if(currPages + books.get(i) <= pages){
                currPages += books.get(i);
            }else{
                currPages = books.get(i);
                currStud++;
            }

            if(currStud > m)
                return false;
        }
        return true;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        //edge case, when no of students are more than no of book, we can't assign each book to each student
        if(m > n)
            return -1;
        
        int low = Integer.MIN_VALUE, high = 0;
        for(int i = 0;i<arr.size();i++){
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            boolean isPossible = checkPossible(mid, arr, m);
            if(isPossible){
                //go to left, as we want minimum
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        //at the end, ans answer is at low
        return low;
    }
}

//time compl - O(n*log(maxArr-sumArr))
//space compl - O(1)
