class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ;  i < n ; i++){
            q.offer(hand[i]);
        }
        
        while(!q.isEmpty()){
            int t1 = q.poll();
            for(int i = 1 ; i < groupSize ; i++){
                if(!q.remove(t1 + i)) return false;
            }
        }
        
        return true;
    }
}