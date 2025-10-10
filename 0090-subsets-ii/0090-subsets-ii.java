class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // sort to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(0, nums, current, ans);
        return ans;
    }

    private void generate(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue; // skip duplicates
            current.add(nums[i]);
            generate(i + 1, nums, current, ans); // ✅ i + 1
            current.remove(current.size() - 1);
        }
    }
}
