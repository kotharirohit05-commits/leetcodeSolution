class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low ; i <= high ; i++){
            String s = String.valueOf(i);
            int l = s.length();
            if(l%2 != 0) continue;
            int ls = 0;
            int rs = 0;
            int half = l / 2;
            for(int k = 0 ; k < half ; k++){
                ls += s.charAt(k) - '0';
                rs += s.charAt(half + k) - '0';
            }
            if(rs == ls) count += 1;


        }
        return count;
    }
}