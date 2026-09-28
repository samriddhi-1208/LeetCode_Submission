/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if(root==null) return "";
       StringBuilder sb = new StringBuilder();
       preorder(root,sb);
       return sb.toString(); 
    }
    void preorder(TreeNode root, StringBuilder sb){
        if(root==null)return;
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.length()==0){
        return null;
       } 
       String[] vals = data.split(",");
       Queue<Integer> q =new LinkedList<>();
       for(String v:vals){
        q.offer(Integer.parseInt(v));

       }
       return build(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode build(Queue<Integer> q,int min,int max){
        if(q.isEmpty()){
            return null;
        }
        int val = q.peek();
        if(val<min || val>max){
            return null;
        }
        q.poll();
        TreeNode root=new TreeNode(val);
        root.left=build(q,min,val);
        root.right=build(q,val,max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;