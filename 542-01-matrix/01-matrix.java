class Solution {
    public int[][] updateMatrix(int[][] mat) {
    //    int r = mat.length;
    //    int c = mat[0].length;
    //    int[][] ans = new int[r][c];
    //    for(int i = 0;i<r;i++){
    //     for(int j = 0;j<c;j++){
    //         if(mat[i][j]==0){
    //             ans[i][j]=0;
    //         }
    //         else{
    //             ans[i][j]=Integer.MAX_VALUE;
    //         }
    //     }
    //    }
    //    for(int i = 0;i<r;i++){
    //     for(int j=0;j<c;j++){
    //         if(mat[i][j]==0){
    //             dfs(mat,ans,i,j,0);
    //         }
    //     }
    //    } 
    //    return ans;
    // }
    // void dfs(int[][] mat,int[][] ans, int r,int c,int d){
    //     int row = mat.length;
    //     int col = mat[0].length;
    //     if(r<0 || r>=row || c<0 || c>=col){
    //         return;
    //     }
    //     if(ans[r][c]<=d){
    //         return;
    //     }
    //           ans[r][c]=d;
    //     dfs(mat,ans,r+1,c,d+1);
    //     dfs(mat,ans,r-1,c,d+1);
    //     dfs(mat,ans,r,c+1,d+1);
    //     dfs(mat,ans,r,c-1,d+1);

        int r = mat.length;
        int c = mat[0].length;

        int[][] ans = new int[r][c];

        Queue<int[]> q = new LinkedList<>();

        // Put all 0s in queue
        // 1s will initially have -1
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } 
                else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] dir = { {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] d : dir) {

                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < r &&
                    nc >= 0 && nc < c &&
                    ans[nr][nc] == -1) {

                    ans[nr][nc] = ans[row][col] + 1;

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return ans;
    }
}
