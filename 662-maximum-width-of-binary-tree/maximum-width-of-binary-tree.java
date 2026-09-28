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
class Pair{
    TreeNode node;
    long index;
    Pair(TreeNode node , long index){
        this.node = node;
        this.index=index;
    }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
           Queue<Pair> q = new LinkedList<>();
           if(root==null)return 0;
        q.offer(new Pair(root,0L));
        int max=0;

        while(!q.isEmpty()){
            int size= q.size();

            long l = q.peek().index;
            long r = l;
            for(int i=0;i<size;i++){
              Pair p= q.poll();
              TreeNode node = p.node;
              long index= p.index;
              r= index;
               if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }
            max= Math.max(max,(int)(r-l+1));
        }
        
        return max;
    }
}