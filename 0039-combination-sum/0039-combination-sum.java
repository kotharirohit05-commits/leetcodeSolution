class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(0 , candidates , target , current , ans);
        return ans;
    }
    private void helper(int i , int[] candidates , int target , List<Integer>current , List<List<Integer>> ans){
        int n = candidates.length;
        if(i == n){
            if(target == 0){
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(candidates[i] <=  target ){
            current.add(candidates[i]);
            helper(i , candidates , target - candidates[i] , current , ans);
            current.remove(current.size() - 1);
        }
        helper(i+1 , candidates , target  , current , ans);
    }
}