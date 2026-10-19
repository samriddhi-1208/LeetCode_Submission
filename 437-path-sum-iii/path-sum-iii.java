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
    int c;

    public int pathSum(TreeNode root, int targetSum) {
        c = 0;
        path(root, targetSum);
        return c;
    }

    void path(TreeNode root, long targetSum) {
        
        if (root == null) {
            return;
        }

        bt(root, targetSum);
        path(root.left, targetSum);
        path(root.right, targetSum);
    }

    void bt(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            c++;
        }
        bt(root.left, targetSum);
        bt(root.right, targetSum);
    }
}
