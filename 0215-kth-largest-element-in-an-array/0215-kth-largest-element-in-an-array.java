class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue();
        for(int x : nums){
            maxheap.offer(x);
            
            if(maxheap.size() >= k + 1){
                maxheap.poll();
            }
        }
        
        return maxheap.peek();
    }
}