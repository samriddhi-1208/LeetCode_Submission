class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,1);

        int ans=1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i ]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
        // return solve(0,-1,nums);

    }
//     int solve(int idx,int prev_idx,int[] nums){
//         if(idx==nums.length)return 0;
//         int notTake = solve(idx+1,prev_idx,nums);
// int take =0;
//         if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
//        take=1+solve(idx+1,idx,nums);
            
//         }
//           return Math.max(take, notTake);
//     }
}