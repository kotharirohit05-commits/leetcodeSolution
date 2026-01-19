class Solution {
    public int maxDepth(String s) {
        int count = 0 ;
        int depth = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                count += 1;
                depth = Math.max(depth , count);
            }else if(c == ')'){
                count -= 1;
            }else{
                continue;
            }
        }
        return depth;
    }
}