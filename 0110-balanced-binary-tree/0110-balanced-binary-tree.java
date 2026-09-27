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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        balancedTree(root);
        return flag;
    }

    private int balancedTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTree = balancedTree(root.left);
        int rightTree = balancedTree(root.right);

        if(Math.abs(leftTree - rightTree) > 1) {
            flag = false;
        }

        return Math.max(leftTree, rightTree)+1;
    }
}