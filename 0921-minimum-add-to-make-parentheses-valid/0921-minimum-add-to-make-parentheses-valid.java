class Solution {
    public int minAddToMakeValid(String s) {
        
        int on = 0;
        int cn = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                on++;
            }else{
                if(on > 0){
                    on--;
                }else{
                    cn++;
                }
            }
        }
        return on + cn;

    }
}