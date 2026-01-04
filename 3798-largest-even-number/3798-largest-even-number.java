class Solution {
    public String largestEven(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == '2'){
                break;
            }
            count++;
        }
        for(int i = 0 ; i < s.length() - count ; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}