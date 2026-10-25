class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //removing the islands connecting to the boundary
        for(int i = 0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for(int j = 0;j<n;j++){
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int c=0;
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(grid[i][j]==0){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;

    }
    void dfs(int[][] grid,int i ,int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m||j>=n ||grid[i][j]==1){
return;
        }
        grid[i][j]=1;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
            }
}