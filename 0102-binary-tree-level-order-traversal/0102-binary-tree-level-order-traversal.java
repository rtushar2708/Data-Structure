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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderTraversal(root);
        return res;
    }
    private void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                res.add(new ArrayList(ls));
                ls.clear();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                ls.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}