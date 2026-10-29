class Solution {
    public int uniquePaths(int m, int n) {
        //Bottom up dp approach
// int[][] dp = new int[m][n];
// for(int i =0;i<m;i++)dp[i][0]=1;
// for(int j = 0;j<n;j++)dp[0][j]=1;
// for(int i =1;i<m;i++){
//     for(int j =1;j<n;j++){
// dp[i][j]=dp[i-1][j]+dp[i][j-1];
//     }
// }
// return dp[m-1][n-1];
//recursive
// return f(0,0,m,n);
//     }
//     public int f(int i , int j , int m , int n){
//         if(i>=m || j>=n){
//             return 0;
//         }
//         if(i==m-1 || j==n-1){
//             return 1;
//         }
//         int d = f(i+1,j,m,n);
//         int r = f(i,j+1,m,n);
//         return d+r;

// top down 
int[][] dp = new int[m][n];
for(int i = 0;i<m;i++){
    Arrays.fill(dp[i],-1);
}
return f(0,0,m,n,dp);
    }
    public int f(int i, int j, int m, int n, int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d = f(i+1,j,m,n,dp);
        int r = f(i,j+1,m,n,dp);
        return dp[i][j]=d+r;
    }
}