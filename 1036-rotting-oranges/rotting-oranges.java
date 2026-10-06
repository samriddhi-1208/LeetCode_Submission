class Solution {
    public int orangesRotting(int[][] grid) {
//         if(grid==null || grid.length==0){ return -1;}
//       int r=grid.length;
//       int c=grid[0].length;
// int fresh = 0;
// Queue<int[]> q = new ArrayDeque<>();
// for(int i = 0;i<r;i++){
//     for(int j = 0;j<c;j++){
//         if(grid[i][j]==1)fresh++;
//         else if(grid[i][j]==2){
//             q.add(new int[]{i,j});
//         }
//     }
// }
// if(fresh==0) return 0;
// int minutes = 0;
// int[] rowDir={-1,1,0,0};
// int[] colDir={0,0,-1,1};
// while(!q.isEmpty()){
//     int size = q.size();
//     for(int i = 0;i<size;i++){
//         int[] curr = q.poll();
//         for(int k = 0;k<4;k++){
//             int x = curr[0]+rowDir[k];
//             int y = curr[1]+colDir[k];
//             if(x>=0 && y>=0 && x<r && y<c && grid[x][y]==1){
//                 fresh--;
//                 grid[x][y]=2;
//                 q.add(new int[] {x,y});
//             }
//         }
//     }
//     minutes++;
// }
// return fresh==0?minutes-1:-1;
       int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        // Put all rotten oranges in queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
     int min = 0;
        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while (!q.isEmpty() && fresh > 0) {
           int size = q.size();
            // One complete BFS level = one minute
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
              int c = curr[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < row &&
                        nc >= 0 && nc < col &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                   fresh--;
                q.add(new int[]{nr, nc});
                    }
                }
            }
            min++;
        }
        if (fresh > 0) {
            return -1;
        }
        return min;
    }
}