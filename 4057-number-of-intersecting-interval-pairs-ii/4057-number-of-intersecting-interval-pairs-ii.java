class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        long count = 0;

        for(int i = 0; i < intervals.length; i++){

            int curr = intervals[i][1];
            int start = i + 1;
            int end = intervals.length - 1;
            int ans = i;

            while(start <= end){
                int mid = start + (end - start) / 2;
                if(intervals[mid][0] > curr){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                    ans = mid;
                }
            }

            count += ans - i;

        }

        return count;
    }
}