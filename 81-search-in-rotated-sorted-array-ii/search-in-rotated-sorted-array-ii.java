class Solution {
    public boolean search(int[] nums, int target) {
       int l = 0;
       int h = nums.length-1;
       while(l<=h){
        int m = l+(h-l)/2;
        if(nums[m]==target) return true;
//ye humne iss use kiya hai taaki hum confuse na ho jab same elements ho jaise ki 1 1 1 1 3 1 , isme condusion hoga ki kaha se rotate hua hai.
        if(nums[l]==nums[m]&&nums[h]==nums[m]){
            l++;
            h--;
        }
        else if(nums[l]<=nums[m]){
if(nums[l]<=target && target<nums[m]){
    h=m-1;
}
else{
    l=m+1;
}
        }
        else{
            if(nums[m]<target && target<=nums[h]){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        
       } 
       return false;
    }
}