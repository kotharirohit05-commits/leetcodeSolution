class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            int num = s.charAt(i);

            StringBuilder small = new StringBuilder();

            while (num > 0) {
                int temp = num % 2;
                small.append(temp);
                num /= 2;
            }

            while (small.length() < 8) {
                small.append('0');
            }

            sb.append(small.reverse());
        }

        int left = 0;
        int right = s.length() * 8 - 1;

        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;


    }
}