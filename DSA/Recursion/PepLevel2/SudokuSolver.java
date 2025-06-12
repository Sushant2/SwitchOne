//write a program to fill the sudoku such that each & every cell is unique in row col & submatrix

package PepLevel2;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public boolean solve(char[][] board, int i, int j){
        //+ve base case - done with board
        if(i == board.length){
            return true;
        }

        //move to next row
        if(j == board[0].length)
            return solve(board, i+1, 0);

        //move to next col
        if(board[i][j] != '.')
            return solve(board, i, j+1);

        if(board[i][j] == '.'){
            for(char ch = '1';ch<='9';ch++){
                if(isPossible(board, i, j, ch)){
                    board[i][j] = ch;
                    if(solve(board, i, j+1))
                        return true;
                    board[i][j] = '.';
                }
            }
        }
        return false; //no valid digit found
    }
    public boolean isPossible(char[][] board, int x, int y, char ch){
        //check in row
        for(int j = 0;j<9;j++){
            if(board[x][j] == ch)
                return false;
        }

        //check in col
        for(int i = 0;i<9;i++){
            if(board[i][y] == ch)
                return false;
        }

        //check in submatrix
        //to find the 'starting cell/top left cell' of a 3*3 submatrix from a cell(i, j)
        //topLeftI = 3*(i/3)
        //topLeftJ = 3*(j/3)

        int topLeftI = 3*(x/3);
        int topLeftJ = 3*(y/3);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[topLeftI+i][topLeftJ + j] == ch)
                    return false;
            }
        }

        return true;
    }
}