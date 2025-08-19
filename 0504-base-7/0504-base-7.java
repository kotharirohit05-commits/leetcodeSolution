class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";  // edge case
        
        boolean neg = num < 0;     // check if negative
        num = Math.abs(num);       // work with positive
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(num % 7);    // remainder → digit
            num /= 7;              // move to next
        }
        
        if (neg) sb.append("-");   // add sign if needed
        return sb.reverse().toString(); // reverse to get correct order
    }
}
