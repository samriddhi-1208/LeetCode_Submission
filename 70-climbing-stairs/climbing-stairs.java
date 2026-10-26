class Solution {
    public int climbStairs(int n) {
// if(n==0||n==1) return 1;
// int[] dp = new int[n+1];
// dp[0]=1;
// dp[1]=1;
// for(int i = 2;i<=n;i++){
// dp[i]=dp[i-1]+dp[i-2];
// }
// return dp[n];
if(n<=2) return n;
int step1=1;
int step2=2;
for(int i = 3;i<=n;i++){
    int curr= step1+step2;
    step1=step2;
    step2=curr;
}
return step2;
    }}