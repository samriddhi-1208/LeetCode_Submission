class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp= new ArrayList<>();
        f(0,s,temp,ans);
        return ans;
    }
    void f(int id,String s,List<String> temp,List<List<String>> ans){
        if(id==s.length()){
        ans.add(new ArrayList<>(temp));
        return;
    }
    for(int i = id;i<s.length();i++){
        String su = s.substring(id,i+1);
        if(palindrome(su)){
            temp.add(su);
            f(i+1,s,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
boolean palindrome(String s){
    int l =0;
    int r =s.length()-1;
    while(l<r){
        if(s.charAt(l)!=s.charAt(r)){
            return false;
        }
        l++;
        r--;
    }
    return true;
}
}