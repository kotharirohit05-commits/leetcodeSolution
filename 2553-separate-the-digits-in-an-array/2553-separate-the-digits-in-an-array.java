class Solution {
    public int[] separateDigits(int[] nums) {
    
        int totalDigits = 0;
        for (int num : nums) {
            totalDigits += Integer.toString(num).length();
        }
        
        int[] answer = new int[totalDigits];
        int index = totalDigits - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];
            while (val > 0) {
                answer[index--] = val % 10;
                val /= 10;
            }
        }
        
        return answer;
    }
}
