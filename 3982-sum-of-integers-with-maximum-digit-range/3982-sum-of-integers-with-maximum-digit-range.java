class Solution {
    public int maxDigitRange(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            int temp = number;
            int h = 0;
            int l = Integer.MAX_VALUE;
            while(temp > 0){
                h = Math.max(h, temp % 10);
                l = Math.min(l, temp % 10);
                temp /= 10;
            }
            arr[i] = h - l;
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(arr[i] == max){
                sum += nums[i];
            }
        }
        return sum;
    }
}