class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helper( 0 ,candidates , target , ans , current);
        return ans;
    }
    private void helper(int ind, int[] candidates , int target ,List<List<Integer>> ans, List<Integer> current ){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = ind ; i < candidates.length ; i++){
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
        
            current.add(candidates[i]);
            helper( i + 1, candidates , target - candidates[i] , ans , current);
            current.remove(current.size() - 1);
        }



    }
}