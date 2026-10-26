class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        f(ans,temp,nums,0);
        return ans;
    }
    public void f(List<List<Integer>> ans,List<Integer> temp,int[] nums,int id){
        ans.add(new ArrayList<>(temp));
        for(int i =id;i<nums.length;i++){
            if(i>id && nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            f(ans,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}