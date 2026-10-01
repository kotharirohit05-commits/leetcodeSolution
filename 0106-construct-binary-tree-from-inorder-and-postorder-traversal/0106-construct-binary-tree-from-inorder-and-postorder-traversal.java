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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;

    }

    private TreeNode helper(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer,Integer> map){

        if(iStart > iEnd || pStart > pEnd) return null;

        TreeNode root = new TreeNode(postorder[pEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - iStart;

        root.left = helper(postorder, pStart, pStart + numsLeft - 1, inorder, iStart, inRoot - 1, map);

        root.right = helper(postorder, pStart + numsLeft , pEnd - 1, inorder, inRoot + 1, iEnd, map);

        return root;

    }



}