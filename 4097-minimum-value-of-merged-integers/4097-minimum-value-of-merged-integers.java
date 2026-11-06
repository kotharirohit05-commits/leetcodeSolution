class Solution {
    public int minMergedInteger(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i+= 2){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            sb.append(nums[i+1]);
            int x = Integer.parseInt(sb.toString());
            queue.add(x);
        }
        return queue.peek();
    }
}