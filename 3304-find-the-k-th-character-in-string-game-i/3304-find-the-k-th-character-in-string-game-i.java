class Solution {
    public char kthCharacter(int k) {
        int x = 0;
        while(Math.pow(2,x) <= k){
            x = x + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append('a');
        helper(sb, 0, x);

        return sb.charAt(k -1 );
               
    }

    private void helper(StringBuilder sb, int op, int x){

        if(op == x){
            return;
        }
        int len = sb.length();

        for(int i = 0; i < len; i++){
            sb.append((char)(sb.charAt(i) + 1));
        }
        helper(sb, op + 1, x);

    }

}