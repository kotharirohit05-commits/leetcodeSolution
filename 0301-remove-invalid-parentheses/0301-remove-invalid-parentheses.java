class Solution {
    private int maxLen = 0;
    
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        List<String> res = new ArrayList<>();
        helper(0, s, sb, 0, set);
        return new ArrayList<>(set);
    }

    private void helper(int idx, String s, StringBuilder sb, int count, Set<String> set){

        if(count < 0) return;

        if(idx == s.length()){
            if(count == 0){
                if(sb.length() > maxLen){
                    maxLen = sb.length();
                    set.clear();
                }
                if(sb.length() == maxLen){
                    set.add(sb.toString());
                }
                
            }
            return;
        }
    
        char ch = s.charAt(idx);

        if(ch != '(' && ch != ')'){
            sb.append(ch);
            helper(idx + 1, s, sb, count, set);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }else{

            helper(idx + 1, s, sb, count, set);

            
            sb.append(ch);

            if (ch == '(') {
                helper(idx + 1, s, sb, count + 1, set);
            } else {
                helper(idx + 1, s, sb, count - 1, set);
            }

            sb.deleteCharAt(sb.length() - 1);

        }

        


    }

}