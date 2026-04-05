class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int[] freq = new int[26];
        int underScoreCount = 0;

        for(int i  = 0 ; i < moves.length() ; i++){
            char ch = moves.charAt(i);
            if(ch >= 'A' && ch <='Z'){
                freq[ch - 'A']++;
            }else{
                underScoreCount++; 
            }  
        }


        int max = Math.max(freq[11] , freq[17]);
        int min = Math.min(freq[11] , freq[17]);
        

        return max + underScoreCount - min;
        
    }
}