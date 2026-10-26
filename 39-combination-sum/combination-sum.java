class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(ans,temp,candidates,target,0);
        return ans;
    }
    public void f(List<List<Integer>> ans,List<Integer> temp,int[] candidates,int target,int id){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i =id;i<candidates.length;i++){
            temp.add(candidates[i]);
            f(ans,temp,candidates,target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}