class Solution {
    public int maxHisto(int[] heights){
int n =heights.length;
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
    public int maximalRectangle(char[][] matrix) {
int n=matrix.length;
int m = matrix[0].length;
int curr[]=new int[m];
int ans = 0;
for(int i = 0;i<=n-1;i++){
    for(int j = 0;j<=m-1;j++){
        if(matrix[i][j]=='1'){
            curr[j]++;
    }
    else{
        curr[j]=0;
    }
    }
ans = Math.max(ans,maxHisto(curr));
}
return ans;
    }
}