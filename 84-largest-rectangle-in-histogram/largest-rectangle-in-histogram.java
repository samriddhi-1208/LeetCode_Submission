class Solution {
    public int largestRectangleArea(int[] heights) {
int n = heights.length;
// int ans = 0;
// for(int i = 0;i<n;i++){
//     int l = i;
//     int h = i;
//     while(l>=0 && heights[l]>=heights[i]){
// l--;
//     }
//     while(r<n && heights[r]>=heights[i]){
// r++;
//     }
// int width = right - left - 1;
//             ans = Math.max(ans, width * heights[i]);
// }
// return ans;

        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();
        }
        l[i]=st.isEmpty()?-1:st.peek();    
        st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            r[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int mArea=0;
        for(int i = 0;i<n;i++){
            int w=r[i]-l[i]-1;
            mArea=Math.max(mArea,heights[i]*w);
        }
        return mArea;
    }
}