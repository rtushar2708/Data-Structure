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
    class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    private Info diameter(TreeNode root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftNode = diameter(root.left);
        Info rightNode = diameter(root.right);
        int nodeDiameter = leftNode.height + rightNode.height + 1;
        int maxDiameter = Math.max(nodeDiameter, Math.max(leftNode.diameter, rightNode.diameter));
        int nodeHeight = Math.max(leftNode.height, rightNode.height) + 1;
        return new Info(maxDiameter, nodeHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info res = diameter(root);
        return res.diameter-1;
    }
}