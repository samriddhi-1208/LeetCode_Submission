class Solution {
    public void nextPermutation(int[] nums) {
//         int n = nums.length;
//         for(int i = n-1;i>=0;i--){
//             for(int j = n-2;j>=1;j--)
// {
//     if(nums[i]>nums[j]){
//         int temp = nums[i];
//         nums[i]=nums[j+1];
//         nums[j+1]=temp;
//     }
// }        }
int i = nums.length-1;
while(i>0 && nums[i-1]>=nums[i]){
    i--;
}
if(i==0){
    reverse(nums,0, nums.length-1);
    return;
}
int j = nums.length-1;
while(j>=i && nums[j]<=nums[i-1]){
    j--;
}
swap(nums,i-1,j);
reverse(nums,i,nums.length-1);
    }
private void swap(int[] nums,int i, int j){
    int temp = nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
}
private void reverse(int[] nums,int st, int e){
    while(st<e){
        int t = nums[st];
        nums[st]=nums[e];
        nums[e]=t;
        st++;
        e--;
    }
}

    
}