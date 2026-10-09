class Solution{
    public boolean isMatch(String s,String p){
        return solve(0,0,s,p, new Boolean[s.length()+1][p.length()+1]);
    }
    private boolean solve(int i , int j,String s, String p,Boolean[][] memo){
        if(memo[i][j]!=null) return memo[i][j];
// base case
        if(j==p.length())
        return memo[i][j]=(i==s.length());

        boolean firstMatch=(i<s.length())&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');

        boolean ans;
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            ans = solve(i,j+2,s,p,memo)||(firstMatch && solve (i+1,j,s,p,memo));
        }
        else{
            ans = firstMatch&&solve(i+1,j+1,s,p,memo);
        }
        return memo[i][j]= ans;
    }
}