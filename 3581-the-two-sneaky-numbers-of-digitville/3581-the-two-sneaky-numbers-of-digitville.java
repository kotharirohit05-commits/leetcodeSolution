class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length ;
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1 ; i < n ; i++ ){
            if(nums[i-1] == nums[i]) {
            temp.add(nums[i]);
            }
        }
        int[] ans = new int[temp.size()];
        for(int i = 0 ; i < temp.size()  ; i++){
            ans[i] = temp.get(i);
        }
        return ans ;
    }
}