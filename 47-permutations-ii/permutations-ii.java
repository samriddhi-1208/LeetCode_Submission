class Solution {
           List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        bt(nums,used,temp);
        return ans;
    }
    private void bt(int[] nums,boolean[] used, List<Integer> temp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1]&& !used[i-1])continue;
            used[i]=true;
            temp.add(nums[i]);
            bt(nums,used, temp);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}