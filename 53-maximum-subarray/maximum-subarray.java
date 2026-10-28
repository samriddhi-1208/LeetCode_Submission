class Solution {
    public int maxSubArray(int[] nums) {
// int mSum=nums[0];
// int currSum=nums[0];
// for(int i = 1;i<nums.length;i++){
//     currSum = Math.max(nums[i],currSum+nums[i]);
//     mSum=Math.max(currSum,mSum);
// }
// return mSum;
int n=nums.length;
int[] dp = new int[n];
dp[0]=nums[0];
int mSum=dp[0];
for(int i =1;i<n;i++){
    dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
    mSum=Math.max(dp[i],mSum);
}
return mSum;
    }
}