//write a program to print all lexicographical numbers from 1 to n

package PepLevel2;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) { 
        if(n == 1){
            return List.of(1);
        }
        List<Integer> res = new ArrayList<>();
        //for numbers 1 to 9
        for(int num = 1;num<=9;num++){
            getLex(num, n, res);
        }
        return res;
    }
    public void getLex(int num, int n, List<Integer> res){
        if(num > n)
            return;
        //add yourself
        //call you family - faith
        res.add(num);
        for(int i = 0;i<=9;i++){
            if(num*10 + i <= n)
                getLex(num*10 + i, n, res);
        }
    }
}
