class Solution {
    public int minOperations(String s) {

        int finans = Integer.MAX_VALUE;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int ans = 0;
            int left = 0;
            int right = s.length() - 1;   

                    

            while (left <= right) {
                char a = s.charAt(left);
                char b = s.charAt(right);
                ans += Math.min(Math.abs(a - b), 26 - Math.abs(a - b));
                
                left++;
                right--;
            }

            ans = ans + i;

            finans = Math.min(ans, finans);

            s = s.substring(1) + s.charAt(0);
            count++;

        }

        return finans;
    }
}