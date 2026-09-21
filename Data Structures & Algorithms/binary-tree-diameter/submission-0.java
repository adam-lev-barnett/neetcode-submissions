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
    int totalMaximum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfTreeH(root);
        return totalMaximum;
    }

    private int diameterOfTreeH(TreeNode node) {
        if (node == null) return 0;
        int countL = diameterOfTreeH(node.left);
        int countR = diameterOfTreeH(node.right);
        totalMaximum = Math.max(totalMaximum, countL + countR);
        return 1 + Math.max(countL, countR);
    }
}
