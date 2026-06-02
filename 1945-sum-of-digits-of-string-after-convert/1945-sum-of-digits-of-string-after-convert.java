class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int p = ch - 'a' + 1;
            sb.append(p);
        }
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum = 0;
            for(int j = 0 ; j < sb.length() ; j++){
                int f = sb.charAt(j) - '0';
                sum += f;
            }
            sb = new StringBuilder(String.valueOf(sum));

        }
        return sum;
    }
}