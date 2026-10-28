class Solution {
    int ans =Integer.MAX_VALUE;
       boolean[][][] visited;
    public int minCost(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;
              visited = new boolean[m][n][1024];
        dfs(grid,0,0,grid[0][0]);
       return ans; 
    }
    void dfs(int[][] grid , int i , int j , int xor){
        int m = grid.length;
        int n = grid[0].length;
             if (visited[i][j][xor]) {
            return;
        }

        visited[i][j][xor] = true;
        if(i==m-1 && j==n-1){
            ans = Math.min(ans,xor);
            return;
        }
        if(i+1<m){
            dfs(grid,i+1,j,xor^grid[i+1][j]);
        }
        if(j+1<n){
            dfs(grid,i,j+1,xor^grid[i][j+1]);
        }
    }
}