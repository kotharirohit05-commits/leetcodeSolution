class Solution {
    public int totalWaviness(int num1, int num2) {
       int ans = 0;
       for(int j = num1 ; j <= num2 ; j++){
        String s = Integer.toString(j);
        int n = s.length();
        if(n < 3 ) continue;

        for(int i = 1 ; i < n - 1 ; i++){
            char left = s.charAt(i-1);
            char c = s.charAt(i);
            char right = s.charAt(i+1);
            if((c > left && c > right)||
            (c < left && c < right))
            {
                ans++;
            }
            
        }
       } 
       return ans;
    }
}