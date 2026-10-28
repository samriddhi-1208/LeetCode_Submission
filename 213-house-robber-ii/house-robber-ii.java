class Solution {
    public int rob(int[] nums) {
int n = nums.length;
if(n==1){
    return nums[0];
    }
    int c1 = solve(nums,0,n-2);
    int c2= solve(nums,1,n-1);
    return Math.max(c1,c2);
       }
       int solve(int[] nums,int st,int en){
        int p1=0;
        int p2=0;
for(int i = st;i<=en;i++){
    int curr=Math.max(nums[i]+p2,p1);
    p2=p1;
    p1=curr;
}
return p1;
       }
     
}