class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0,s);
    }
    int solve(int i,String s){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int w=solve(i+1,s);
        if(i+1<s.length()){
             int num = Integer.parseInt(s.substring(i, i + 2));

            if (num >= 10 && num <= 26) {
                w += solve(i + 2, s);
            }
        }
        return dp[i]=w;
    }
}