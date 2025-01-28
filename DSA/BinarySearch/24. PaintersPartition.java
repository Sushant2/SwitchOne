//problem is that we've K painters, and a wall to paint
//an array is given in which units of baords is given to paint
//and we can paint each unit of board in 1 unit of time
//so goal is to divide the boards among painters so that the maximum time taken by any painter is minimized.


//EXACTLY SAME AS BOOK ALLOCATION, CAPACITY TO SHIP PACKAGES, SPLIT ARRAY LARGEST SUM

import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static boolean canPaintWall(ArrayList<Integer> boards, int time, int painters){
        int currPainter = 1, totalTime = 0;
        for(int i = 0;i<boards.size();i++){
            if(totalTime + boards.get(i) <= time){
                totalTime += boards.get(i);
            }else{
                totalTime = boards.get(i);
                currPainter++;
            }
            if(currPainter > painters)
                return false;
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        for(int time=low;time <= high;time++){
            if(canPaintWall(boards, time, k)){
                return time;
            }
        }
        return low;
    }
}

//time compl - O((sumarr-maxarr)*n)
//space compl - O(1)

//Binary Search
import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static boolean canPaintWall(ArrayList<Integer> boards, int time, int painters){
        int currPainter = 1, totalTime = 0;
        for(int i = 0;i<boards.size();i++){
            if(totalTime + boards.get(i) <= time){
                totalTime += boards.get(i);
            }else{
                totalTime = boards.get(i);
                currPainter++;
            }
            if(currPainter > painters)
                return false;
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low <= high){
            int mid = low + (high-low)/2;
            if(canPaintWall(boards, mid, k)){
                //goto left - as to minimize time
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
//time compl - O(logn(sumarr-maxarr)*n)
//space compl - O(1)