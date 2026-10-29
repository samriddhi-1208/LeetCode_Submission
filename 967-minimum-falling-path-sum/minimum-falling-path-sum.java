class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
             int ans=Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
   

for (int j=0; j < n; j++) {
    ans=Math.min(ans, f(0, j, n, matrix, dp));
}

return ans;
    
    }
    public int f(int i,int j,int n, int[][] matrix,int[][] dp){
        if(j<0 || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==n-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int d= f(i+1,j,n,matrix,dp);
        int ld=f(i+1,j-1,n,matrix,dp);
        int rd=f(i+1,j+1,n,matrix,dp);
        return dp[i][j]=matrix[i][j]+Math.min(d,Math.min(ld,rd));
    }
}