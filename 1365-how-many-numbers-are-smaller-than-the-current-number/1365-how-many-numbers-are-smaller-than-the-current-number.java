class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            int count  = 0 ;
            for(int j = 0 ; j < n ;j++){
                if(nums[i] > nums[j]){
                    count += 1;
                }
            }
            arr[k++] = count;
        }
        return arr;
    }
}