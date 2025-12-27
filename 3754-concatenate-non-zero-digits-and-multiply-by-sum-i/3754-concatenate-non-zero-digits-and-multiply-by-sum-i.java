class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '0'){
                sb.append(s.charAt(i));
            }
        }
        long sum = 0;
        for(int i = 0 ; i < sb.length() ; i++){
            sum += sb.charAt(i) - '0';
        }
        long number = Long.parseLong(sb.toString());
        return number * sum;
    }
}