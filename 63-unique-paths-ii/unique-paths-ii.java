class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
//        int r = ob.length;
//        int c = ob[0].length;
//        int[][] dp = new int[r][c];
//        dp[0][0]=1;
//        if(ob[0][0]==1)return 0;
//    for(int i=1;i<r;i++){
//     dp[i][0] = (ob[i][0] == 1) ? 0 : dp[i-1][0];
// }


// for(int j=1;j<c;j++){
//     dp[0][j] = (ob[0][j] == 1) ? 0 : dp[0][j-1];
// }  
    
//      for(int i=1;i<r;i++){
//         for(int j=1;j<c;j++){
          
//             if(ob[i][j] == 1) dp[i][j] = 0;
//               else dp[i][j] = dp[i-1][j] + dp[i][j-1];
//         }
//      }
//      return dp[r-1][c-1];
int m = ob.length;
int n = ob[0].length;
int[][] dp = new int[m][n];
for(int i = 0;i<m;i++){
    Arrays.fill(dp[i],-1);
}
return f(0,0,ob,m,n,dp);
    }
    public int f(int i,int j,int[][] ob,int m,int n,int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
                if(ob[i][j]==1){
            return 0;
        }
        if(i==m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d = f(i+1,j,ob,m,n,dp);
        int r=f(i,j+1,ob,m,n,dp);
        return dp[i][j]=d+r;
    }
}

