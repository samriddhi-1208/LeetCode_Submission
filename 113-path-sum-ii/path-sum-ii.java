/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        bt(ans,temp,targetSum,root);
        return ans;
    }
    void bt(List<List<Integer>> ans,List<Integer> temp,int targetSum, TreeNode root){
        if(root==null)return;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                ans.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size()-1);
            return;
        }
        bt(ans,temp,targetSum-root.val,root.left);
        bt(ans,temp,targetSum-root.val,root.right);
        temp.remove(temp.size()-1);
    }
}