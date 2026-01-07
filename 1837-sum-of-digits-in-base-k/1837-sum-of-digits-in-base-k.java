class Solution {
    public int sumBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int dig = n % k;
            String s = String.valueOf(dig);
            sb.append(dig);
            n/= k;
        }
        sb.reverse();
        String a = sb.toString();
        int val = Integer.parseInt(a);
        int sum = 0;
        while(val > 0){
            int dig = val % 10;
            sum += dig;
            val /= 10;
        }
        return sum;
        
    }
}