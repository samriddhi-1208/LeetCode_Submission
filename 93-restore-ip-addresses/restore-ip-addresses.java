class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        f(s,0,0,"",ans);
        return ans;
    }
    void f(String s,int ind,int parts,String curr,List<String> ans){
        if(parts==4){
            if(ind==s.length()){
                ans.add(curr.substring(0,curr.length()-1));
            }
            return;
        }
        for(int l=1;l<=3;l++){
            if(ind+l>s.length()){
                break;
            }
            String p=s.substring(ind,ind+l);
            if(p.length()>1 && p.charAt(0)=='0'){
                break;
            }
            if(Integer.parseInt(p)>255){
                break;
            }
            f(s,ind+l,parts+1,curr+p+".",ans);
        }
    }
}