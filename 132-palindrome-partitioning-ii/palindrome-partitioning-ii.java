class Solution {
    int[][] dp;
      int n;
    public int minCut(String s) {
    n = s.length();
        dp = new int[n][n];
        for(int[] rows: dp){
        Arrays.fill(rows,-1);
        }
        return solve(0,n-1,s);
    }
    int solve(int i,int j, String s){
if(i>=j || isPal(s,i,j)){
    return 0;
} 
        if(dp[i][j]!=-1) return dp[i][j];
        int ans =Integer.MAX_VALUE;
for(int k = i;k<j;k++){
    if(isPal(s,i,k)){
int c= 1+solve(k+1,j,s);
ans =Math.min(ans,c);

    }

}
return dp[i][j]= ans;
    }
    boolean isPal(String s,int i, int j){

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}