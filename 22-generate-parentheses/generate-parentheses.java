class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,0,0,"",ans);
        return ans;

    }
    public void solve(int n,int op,int cl,String s,List<String> ans){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(op<n){
            solve(n,op+1,cl,s+"(",ans);
        }
        if(cl<op){
            solve(n,op,cl+1,s+")",ans);
        }
    }
}