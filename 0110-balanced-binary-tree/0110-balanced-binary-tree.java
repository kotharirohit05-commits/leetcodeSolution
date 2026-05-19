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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int lhs = dfs(root.left);
        if(lhs == -1) return -1;

        int rhs = dfs(root.right);
        if(rhs == -1) return -1;

        
        if(Math.abs(lhs - rhs) > 1) return -1;

        return Math.max(lhs,rhs) + 1;

    }
}