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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
if(root==null){
    return 0;
}
List<Integer> temp = new ArrayList<>();
bt(root,(long)targetSum,temp);
pathSum(root.left,targetSum);
pathSum(root.right,targetSum);
return count;

    }
    void bt(TreeNode root,long targetSum,List<Integer> temp){
        if(root==null)return;
        temp.add(root.val);
        targetSum-=root.val;
        if(targetSum==0){
            count++;
        }
        bt(root.left,targetSum,temp);
        bt(root.right,targetSum,temp);
        temp.remove(temp.size()-1);
    }
}