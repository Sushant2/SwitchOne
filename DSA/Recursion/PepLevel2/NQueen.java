package PepLevel2;

//Using Branch And Bound Method
//Just mark the arrays of columns, lefDiaognal & rightDiaognal - to avoid going in that direction as we can't place queeen there
public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] chess = new boolean[n][n];
        boolean[] colArr = new boolean[n];
        boolean[] leftD = new boolean[2*n-1];
        boolean[] rightD = new boolean[2*n-1];

        placeNQueen(chess, 0, colArr, leftD, rightD, "");
    }
    public static void placeNQueen(boolean[][] chess, int row, boolean[] colArr, boolean[] leftD, boolean[] rightD, String qsf){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }

        for(int col = 0;col<chess.length;col++){
            if(colArr[col] == false && leftD[row+col] == false && rightD[row-col+chess.length-1] == false){
                chess[row][col] = true;
                colArr[col] = true;
                leftD[row+col] = true;
                rightD[row-col+chess.length-1] = true;
                placeNQueen(chess, row+1, colArr, leftD, rightD, qsf + row  + "-" + col + ", ");
                chess[row][col] = false;
                colArr[col] = false;
                leftD[row+col] = false;
                rightD[row-col+chess.length-1] = false;
            }
        }
    }
}
