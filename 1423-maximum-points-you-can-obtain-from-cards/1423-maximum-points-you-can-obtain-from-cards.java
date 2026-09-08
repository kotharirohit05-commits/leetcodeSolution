class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int currsum = 0;
        
        for(int i = 0; i < k; i++){
            currsum += cardPoints[i];
        }
        
        int maxscore = currsum;

        int j = n - 1;

        for(int i = k - 1; i >= 0; i--){
            currsum = currsum - cardPoints[i] + cardPoints[j];
            maxscore = Math.max(maxscore, currsum);
            j--;
        }
        return maxscore;

    }
}