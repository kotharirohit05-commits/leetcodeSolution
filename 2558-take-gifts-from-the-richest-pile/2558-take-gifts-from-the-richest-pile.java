class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> maxh = new PriorityQueue(Collections.reverseOrder());
        for(int x : gifts){
            maxh.offer(x);
        }
        while( k > 0){
             double a= maxh.poll();
            double sqrt = Math.sqrt(a);
            maxh.offer((int)(a / sqrt));
            k--;
        }
        long sum = 0 ;
        while(!maxh.isEmpty()){
            sum += maxh.poll();
        }
        return sum;

    }
}