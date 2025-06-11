//write a progarm to find max gold sum in 2d matrix from any cell to any cell
//can't visit same cell
//can't include cell having 0
//moves TLDR
package PepLevel2;

public class PathWithMaxGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0, gold = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    gold = collectGold(grid, visited, i, j);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }
    public int collectGold(int[][] grid, boolean[][] visited, int i, int j){
        //-ve case
        if(i < 0 || j < 0 || i>= grid.length || j>= grid[0].length || grid[i][j] == 0 || visited[i][j] == true)
            return 0;
        
        int sum = grid[i][j];
        visited[i][j] = true;
        int top = collectGold(grid, visited, i-1, j);
        int left = collectGold(grid, visited, i, j-1);
        int down = collectGold(grid, visited, i+1, j);
        int right = collectGold(grid, visited, i, j+1);
        visited[i][j] = false;
        return Math.max(top, Math.max(left, Math.max(down, right))) + sum;
    }
}
