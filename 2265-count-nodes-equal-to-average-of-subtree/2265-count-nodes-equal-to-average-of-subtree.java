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
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return matchingNodesCount;
    }

    private int[] dfs(TreeNode node) {
        // Base case: null node contributes 0 to both sum and count
        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        // Recursively calculate values for left and right subtrees
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Compute aggregate values for the current node's subtree
        int subtreeSum = node.val + left[0] + right[0];
        int subtreeCount = 1 + left[1] + right[1];

        // Integer division automatically handles rounding down (floor division)
        if (node.val == (subtreeSum / subtreeCount)) {
            matchingNodesCount++;
        }

        // Return the accumulated values to the parent caller
        return new int[]{subtreeSum, subtreeCount};
    }
}
