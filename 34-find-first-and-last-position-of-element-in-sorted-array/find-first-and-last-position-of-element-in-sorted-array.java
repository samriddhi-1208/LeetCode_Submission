class Solution {
    public int[] searchRange(int[] nums, int target) {
      int first=firstOcc(nums,target);
      if(first==-1) return new int[]{-1,-1};
      int last =lastOcc(nums,target);
      return new int[]{first,last};

    }
    public int firstOcc(int[] nums,int target){
        int ans = -1;
        int l = 0;
        int h =nums.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                ans=m;
                h=m-1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return ans;
    }
    public int lastOcc(int[] nums,int target){
        int ans = -1;
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                ans = m;
                l=m+1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                h=m-1;
        }
        }
        return ans;
    }
}