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
    int maxSum;
    private int pathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);

        int subTree = leftSum + rightSum + root.val;
        int subPath = Math.max(leftSum, rightSum) + root.val;
        maxSum = Math.max(maxSum, Math.max(subTree, Math.max(subPath, root.val)));
        return Math.max(subPath, root.val);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        pathSum(root);

        return maxSum;
    }
}