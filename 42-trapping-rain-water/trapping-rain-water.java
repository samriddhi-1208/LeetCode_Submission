class Solution {
    public int trap(int[] height) {
        // int i = 0;
        // int j = height.length-1; 
        // int ans = 0; 
        // int leftmax=0;
        // int rightmax=0;
        // while(i<j){
        //     if(height[i]<=height[j]){
        //         if(height[i]>leftmax){
        //         leftmax=height[i];
        //     }
        //     else{
        //         ans+=leftmax-height[i];
        //     }
        //     i++;
        //     }
        //     else{
        //         if(height[j]>rightmax){
        //             rightmax=height[j];
        //         }
        //         else{
        //              ans+=rightmax-height[j];
        //         }
        //         j--;
        //     }
        // }
        // return ans;

        int n = height.length;
//Left side max heights
int[] leftMax = new int[n];
// right side max heights
int[] rightMax= new int[n];
//first element ka left ,ax woh khud hoga
leftMax[0] = height[0];
//left max array build karo
for(int i =1;i<n;i++){
    leftMax[i]=Math.max(leftMax[i-1],height[i]);
}
//last element ka right max woh khud hoga 
rightMax[n-1] = height[n-1];
//Right max array build karo
for(int i = n-2;i>=0;i--){
    rightMax[i]=Math.max(rightMax[i+1],height[i]);
}
int water=0;
for(int i = 0;i<n;i++){
    water+=Math.min(leftMax[i],rightMax[i])-height[i];
}
return water;
        }
}