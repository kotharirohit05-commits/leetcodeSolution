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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root , list , 0);
        return list;
    }
    private void helper(TreeNode root , List<Integer> list, int curdepth){
        if(root == null){
            return;
        }
        if(curdepth == list.size()){
            list.add(root.val);
        }

        helper(root.right , list , curdepth + 1);
        helper(root.left  , list , curdepth + 1);
    }
}