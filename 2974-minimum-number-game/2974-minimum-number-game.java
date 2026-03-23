class Solution {
    public int[] numberGame(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for(int i = 0 ; i  < nums.length ; i++){
            minh.offer(nums[i]);
        }
        int count = 0 ;
        while(!minh.isEmpty()){
            int a = minh.poll();
            if(count % 2 == 0){
                ans[count+1] = a;
            }else{
                ans[count-1] = a;
            }
            count++;
        }
        return ans;
    }
}