class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        f(ans,temp,nums,used);
        return ans;
    }
    public void f(List<List<Integer>> ans,List<Integer> temp,int[] nums,boolean[] used){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            temp.add(nums[i]);
            f(ans,temp,nums,used);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}