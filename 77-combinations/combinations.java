class Solution {
    List<List<Integer>> ans =  new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       List<Integer> temp = new ArrayList<>();
       bt(1,n,k,temp);
       return ans; 
    }
    public void bt(int ind,int n,int k ,List<Integer> temp){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = ind;i<=n;i++){
            temp.add(i);
            bt(i+1,n,k,temp);
            temp.remove(temp.size()-1);
        }
    }
}