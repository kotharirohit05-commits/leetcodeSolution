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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        helper(root , arr);
        return arr[0];
    }
    private int helper(TreeNode root , int[] arr){
        if(root == null) return 0;
        int lhs = helper(root.left , arr);
        int rhs = helper(root.right , arr);
        
        arr[0] = Math.max(arr[0] , lhs + rhs);
        return 1 + Math.max(lhs , rhs);
    }
}