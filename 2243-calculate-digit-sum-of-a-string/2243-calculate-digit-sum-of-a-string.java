class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i+= k){
                int grp = 0;
                for(int j = i; j < i + k && j < s.length(); j++){
                    grp += s.charAt(j) - '0';
                }
                sb.append(grp);
            }
            s = sb.toString();
        }
        return s;

    }
}