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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int result = maxDepthH(root, 0);
        return result;
    }

    private int maxDepthH(TreeNode node, int depth) {
        if (node == null) return depth;
        int depthL = 0;
        int depthR = 0;
        depthL = (1 + maxDepth(node.left));
        depthR = (1 + maxDepth(node.right));
        return Math.max(depthL, depthR);
    }
}
