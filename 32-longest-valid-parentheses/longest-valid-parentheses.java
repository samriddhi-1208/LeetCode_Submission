class Solution {
    public int longestValidParentheses(String s) {
    // Stack<Integer> st = new Stack<>();
    // st.push(-1);
    //     int l = 0;
    //     for(int i = 0;i<s.length();i++){
    //         if(s.charAt(i)=='('){
    //             st.push(i);
    //         }
    //         else{
    //             st.pop();
    //             if(st.isEmpty()) {
    //                 st.push(i);
    //             }else{
    //                 l=Math.max(l,i-st.peek());
    //             }
    //         }
    //     }
    //     return l;

    Stack<Integer> st = new Stack<>();
    boolean[] vis = new boolean[s.length()];
    for(int i = 0;i<s.length();i++){
        if(s.charAt(i)=='('){
            st.push(i);
        }
        else{
            if(!st.isEmpty()){
           int ind= st.pop();
            vis[ind]=true;
            vis[i]=true;
            }
        }
    }
    int c = 0;
    int ans=0;
    for(int i = 0;i<vis.length;i++){
        if(vis[i]==true){
c++;
ans= Math.max(ans,c);
        }
        else{
            c=0;
        }
    }
        return ans;
    }

}