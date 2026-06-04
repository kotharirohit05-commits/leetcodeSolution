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
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for(int x : map.values()){
            max = Math.max(x , max);
        }
        List<Integer> list = new ArrayList<>();
        for(int x : map.keySet()){
            if(map.get(x) == max){
                list.add(x);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private void helper(TreeNode root , HashMap<Integer,Integer> map){
        if(root == null) return;
        map.put(root.val , map.getOrDefault(root.val, 0) + 1);
        helper(root.left, map);
        helper(root.right, map);
    }
}