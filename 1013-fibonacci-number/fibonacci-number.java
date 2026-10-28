class Solution {
    public int fib(int n) {
        // if(n==0) return 0;
        // if(n==1) return 1;
        // int n1 = 1,n2=1,res=1;
        // for(int i = 0;i<n-2;i++){
        //     res=n1+n2;
        //     n1=n2;
        //     n2=res;
        // }
        // return res;
        // if(n==0) return 0;

        // if(n==1) return 1;
        // return fib(n-1)+fib(n-2);
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}