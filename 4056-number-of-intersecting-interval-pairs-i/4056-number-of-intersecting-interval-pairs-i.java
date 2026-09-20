class Solution {
    public int countIntersectingIntervals(int[][] intervals) {

        int count = 0;

        for(int i = 0; i < intervals.length - 1; i++){
            for(int j = i + 1; j < intervals.length; j++){
                int SA = intervals[i][0];
                int EA = intervals[i][1];
                int SB = intervals[j][0];
                int EB = intervals[j][1];
                if(SA <= EB && SB <= EA){
                    count++;
                }
            }
        }

        return count;
        
    }
}