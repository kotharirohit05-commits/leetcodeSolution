class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> missing = new ArrayList<>();
        int a= nums[0];
        int end = nums[n-1];
        int i = 0;
        while( a <= end){
            if(i < n && nums[i] == a){
                i++;
            }
            else{
                missing.add(a);
            }
            a++;
            
        }
        return missing;
    }
}