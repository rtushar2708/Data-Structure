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
    Map<Integer, ArrayList<int[]>> list;
    int min=0, max=0;

    private void traverse(TreeNode root, int row, int col) {
        if(root == null) {
            return;
        }
        min = Math.min(min, col);
        max = Math.max(max, col);
        list.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, root.val});
        traverse(root.left, row+1, col-1);
        traverse(root.right, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        list = new HashMap<>();
        traverse(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int col = min; col <= max; col++) {
            ArrayList<int[]> nodes = list.get(col);
            Collections.sort(nodes, (a, b) -> {
                if(a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            List<Integer> currentCol = new ArrayList<>();
            for(int[] node: nodes) {
                currentCol.add(node[1]);
            }
            ans.add(currentCol);
        }
        return ans;
    }
}