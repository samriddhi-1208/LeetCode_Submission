// class Solution {
//     public int numIslands(char[][] grid) {
//     int c = 0;
//     int m = grid.length;
//     int n = grid[0].length;
//     for(int i=0;i<m;i++){
//         for(int j=0;j<n;j++){
//             if(grid[i][j]=='1'){
//                 c++;
//                 dfs(grid,i,j);
//             }
//         }
//     }    
//     return c;
//     }
//     void dfs(char[][] grid,int i,int j){
//         int m = grid.length;
//         int n = grid[0].length;
//         if(i<0 || j<0 || i>=m || j>=n ||grid[i][j]=='0'){
//             return;
//         }
//         grid[i][j]='0';
//         dfs(grid,i+1,j);
//         dfs(grid,i-1,j);
//         dfs(grid,i,j+1);
//         dfs(grid,i,j-1);
//     }
// }
import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1') {
                    count++;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';
                    while (!q.isEmpty()){
                        int[] cell=q.poll();
                        int r=cell[0];
                        int c=cell[1];
                        for (int[] d:dirs) {
                            int nr =r+d[0];
                            int nc =c+d[1];
                            if (nr >= 0 &&nc>=0&&nr<m&&nc<n&&grid[nr][nc]=='1') {
   grid[nr][nc]='0';
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}