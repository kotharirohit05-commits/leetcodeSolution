class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1] , a[1]));
        
        int ans = 0;

        for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
            while(truckSize > 0 && boxTypes[i][0] > 0){
                ans += boxTypes[i][1];
                boxTypes[i][0]--;
                truckSize--;
            }
        }
        
        return ans;

    }
}