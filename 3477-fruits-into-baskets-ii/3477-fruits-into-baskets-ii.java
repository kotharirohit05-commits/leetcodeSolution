class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int f = fruits.length;
        int b = baskets.length;
        boolean[] used = new boolean[f];
        int unplaced = 0;
        
        for(int i = 0 ; i < f ; i++){
            boolean placed = false;
            for(int j = 0 ; j < b ; j++){
                if(!used[j] && fruits[i] <= baskets[j] ){
                    placed = true;
                    used[j] = true;
                    break;
                }   
            }
            if(!placed){
                unplaced++;
            }
        }
        return unplaced;
        

    }
}