/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent;
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            parent.put(root.left, root);
        }
        inorder(root.left);
        if(root.right != null) {
            parent.put(root.right, root);
        }
        inorder(root.right);
        return;

    }

    private List<Integer> BFS(TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(target);
        visited.add(target.val);

        while(!q.isEmpty()) {
            int n = q.size();
            if(k == 0) {
                break;
            }
            while(n > 0) {
                TreeNode curr = q.remove();
                if(curr.left != null && !visited.contains(curr.left.val)) {
                    q.add(curr.left);
                    visited.add(curr.left.val);
                }

                if(curr.right != null && !visited.contains(curr.right.val)) {
                    q.add(curr.right);
                    visited.add(curr.right.val);
                }

                if(parent.get(curr) != null && !visited.contains(parent.get(curr).val)) {
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr).val);
                }
                n--;
            }
            k--;
        }

        while(!q.isEmpty()) {
            result.add(q.remove().val);
        } 
        return result;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        inorder(root);
        BFS(target, k, result);

        return result;
    }
}