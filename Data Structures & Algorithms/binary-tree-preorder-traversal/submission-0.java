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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderHelper(root);
        return this.result;
    }

    public void preorderHelper(TreeNode node) {
        if (node == null) return;
        this.result.add(node.val);
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    
}