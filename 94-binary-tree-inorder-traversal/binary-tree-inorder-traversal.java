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
//  * }
//  */
// class Solution {
    // List<Integer> ans = new ArrayList<>();
    // public List<Integer> inorderTraversal(TreeNode root) {
        // solve(root);
        // return ans;
  //  }
    // void solve(TreeNode root){
    //     if(root==null) return;
    //     solve(root.left);
    //     ans.add(root.val);
    //     solve(root.right);
   // }
//}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
    while (curr != null) {
  // No left child
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            // Left child exists
            else {
                TreeNode prev = curr.left;
                // Find inorder predecessor
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
   // First time visiting curr
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
    // Second time visiting curr
                else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
            return ans;
    }
}