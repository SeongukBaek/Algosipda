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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == q) {
            return true;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(p);
        nodes.add(q);

        while (!nodes.isEmpty()) {
            TreeNode left = nodes.poll();
            TreeNode right = nodes.poll();

            if (left.val != right.val) {
                return false;
            }

            if ((left.left != null && right.left == null) || (left.left == null && right.left != null)) {
                return false;
            } else if (left.left != null) {
                nodes.add(left.left);
                nodes.add(right.left);
            }
            
            if ((left.right != null && right.right == null) || (left.right == null && right.right != null)) {
                return false;
            } else if (left.right != null) {
                nodes.add(left.right);
                nodes.add(right.right);
            }
        }

        return true;
    }
}