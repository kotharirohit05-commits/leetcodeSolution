class Solution {
    public int maxDistance(String moves) {

        int[] arr = new int[26];
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        int uc = 0;

        for(int i = 0; i < moves.length() ; i++){
            if(moves.charAt(i) == '_') uc++;
            else{
                char ch = moves.charAt(i);
                if(ch == 'U'){
                    u++;
                }
                else if(ch == 'D'){
                    d++;
                }
                else if(ch == 'L'){
                    l++;
                }
                else if(ch == 'R'){
                    r++;
                }
            }
        }
        
        int x = Math.abs(l - r);
        int y = Math.abs(u - d);
        return x + y + uc;

    }
}