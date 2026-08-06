class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int temp = n;
            int product = 1;
            
            // Calculate the product of the digits
            while (temp > 0) {
                product *= (temp % 10);
                temp /= 10;
            }
            
            // Check if the product is divisible by t
            if (product % t == 0) {
                return n;
            }
            
            // Try the next number
            n++;
        }
    }
}
