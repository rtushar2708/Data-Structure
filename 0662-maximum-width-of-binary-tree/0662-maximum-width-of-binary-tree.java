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
    class Pair {
        TreeNode root;
        long idx;
        Pair(TreeNode root, long idx) {
            this.root = root;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<Pair> d = new ArrayDeque<>();
        d.addLast(new Pair(root, 0));
        long maxWidth = 0;
        while(!d.isEmpty()) {
            Pair first = d.peekFirst();
            Pair last = d.peekLast();
            long currMax = (last.idx - first.idx) + 1;
            maxWidth = Math.max(currMax, maxWidth);
            int n = d.size();
            while(n > 0) {
                Pair curr = d.removeFirst();
                if(curr.root.left != null) {
                    d.addLast(new Pair(curr.root.left, curr.idx*2 + 1));
                }
                if(curr.root.right != null) {
                    d.addLast(new Pair(curr.root.right, curr.idx*2 + 2));
                }
                n--;
            }
        }

        return (int)maxWidth;
    }
}