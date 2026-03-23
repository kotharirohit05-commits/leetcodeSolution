class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue(Collections.reverseOrder());
        for(int x : nums){
            maxheap.offer(x);
        }

        //n size
        //k size
        k--;
        while(k > 0){
            maxheap.poll();
            k--;
        }
        return maxheap.peek();
    }
}