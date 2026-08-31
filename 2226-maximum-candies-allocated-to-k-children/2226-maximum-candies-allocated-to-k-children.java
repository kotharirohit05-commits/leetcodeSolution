class Solution {
    private long helper(int[] candies, long mid){
        long count = 0;
        int holding = 0;
        for(int i = 0; i < candies.length; i++){
            count += candies[i] / mid;
        }
        return count;
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        
        long low = 1;
        long high = 0;
        long ans = 0;
        for(int x : candies){
            high += x;
        }
        if(k > high) return 0;
        System.out.println(high);
        while(low <= high){
            long mid = low + (high - low) / 2;
            long count = helper(candies, mid);
            if(count >= k){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int)ans;
    }
}