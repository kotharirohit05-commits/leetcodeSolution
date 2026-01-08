class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int a =Math.abs(nums[i] )- 1;
            if(nums[a] > 0){
                nums[a] = -nums[a];
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}