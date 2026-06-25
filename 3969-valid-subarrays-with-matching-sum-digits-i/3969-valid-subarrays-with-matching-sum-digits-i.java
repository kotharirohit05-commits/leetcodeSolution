class Solution {
    public int countValidSubarrays(int[] nums, int x) {

        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            long sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                long last = sum % 10;
                long temp = sum;
                while(temp >= 10){
                    temp /= 10;
                }
                if(temp == last && last == x){
                    count++;
                }
            }
        }
        return count;
    }
}