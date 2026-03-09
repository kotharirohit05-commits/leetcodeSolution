class Solution {
    public int minimumRecolors(String blocks, int k) {

        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(blocks.charAt(i) == 'W'){
                count++;
            }
        }
        int min = count;
        int left = 0;
        for(int j = k ; j < blocks.length() ; j++){
            if(blocks.charAt(j) == 'B'){
                count--;
            }
            if(blocks.charAt(left) == 'B'){
                count++;
            }
            left++;

            min = Math.min(min , count);

        }
        return min;
    }
}