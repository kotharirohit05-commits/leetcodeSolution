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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;

    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer,Integer> map){

        if(iStart > iEnd || pStart > pEnd) return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - iStart;

        root.left = helper(preorder, pStart + 1, pStart + numsLeft, inorder, iStart, inRoot - 1, map);

        root.right = helper(preorder, pStart + numsLeft + 1, pEnd, inorder, inRoot + 1, iEnd, map);

        return root;

    }

}