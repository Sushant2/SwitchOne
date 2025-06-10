//write a program to search a given word horixontally & veritcally adjacent cells in a 2d matrix
package PepLevel2;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1)
                        return true;;
                    boolean isExist = checkExist(board, marked, i, j, word);
                    if(isExist)
                        return true;
                }
            }
        }
        return false;
    }
    public boolean checkExist(char[][] board, boolean[][] marked, int i, int j, String word){
        if(word.length() == 0)
            return true;
        //-ve base case
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || marked[i][j])
            return false;
        
        if(board[i][j] == word.charAt(0)){
            marked[i][j] = true;
            String newWord = word.substring(1);
            boolean res = (checkExist(board, marked, i-1, j, newWord) || 
                            checkExist(board, marked, i, j-1, newWord) ||
                            checkExist(board, marked, i+1, j, newWord) ||
                            checkExist(board, marked, i, j+1, newWord));
            marked[i][j] = false;
            return res;
        }
        return false;
    }
}
