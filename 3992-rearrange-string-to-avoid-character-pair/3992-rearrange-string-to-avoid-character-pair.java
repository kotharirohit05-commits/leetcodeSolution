class Solution {
    public String rearrangeString(String s, char x, char y) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == y) count++;
        }
        while(count--> 0){
            sb.append(y);
        }
        for(char ch : s.toCharArray()){
            if(ch != y){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}