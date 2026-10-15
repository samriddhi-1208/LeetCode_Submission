class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    boolean used[] = new boolean[nums.length];
    List<Integer> temp = new ArrayList<>();
    bt(nums,used,temp);
    return ans;    
    }
    public void bt(int[] nums,boolean[] used,List<Integer> temp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            temp.add(nums[i]);
            bt(nums,used,temp);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}