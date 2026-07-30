class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        int count = 0;
        int p0 = 0;
        int p1 = 8;
        int p2 = 16;
        int p3 = 24;
        int p4 = 26;

        for(int i = 0; i < n; i++){
            if( i >= p0 && i < p1){
                count++;
            }else if( i >= p1 && i < p2){
                count += 2;
            }else if( i >= p2 && i < p3){
                count += 3;
            }else{
                count += 4;
            }
        }
        return count;
    }
}