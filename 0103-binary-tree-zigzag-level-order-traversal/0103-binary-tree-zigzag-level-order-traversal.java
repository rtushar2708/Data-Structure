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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        q.add(null);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                if(count%2 == 0) {
                    ans.add(new ArrayList(list));
                    list = new ArrayList();
                }else {
                    Collections.reverse(list);
                    ans.add(new ArrayList(list));
                    list = new ArrayList();
                }
                if(q.isEmpty()) {
                    break;
                }
                q.add(null);
                count++;
            } else {
                list.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return ans;
    }
}