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
    Map<Integer, Integer> map;
    private void solve(TreeNode root, int row) {
        if(root == null) {
            return;
        }
        map.put(row, root.val);
        solve(root.left, row+1);
        solve(root.right, row+1);
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        solve(root, 0);
        int n = map.size();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}