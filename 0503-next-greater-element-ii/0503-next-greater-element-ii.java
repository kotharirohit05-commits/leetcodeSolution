class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i = 2*n - 1 ; i >= 0 ; i--){
            int element = nums[i % n];
            while(!stack.isEmpty() && element >= stack.peek()){
                stack.pop();
            }
            
            if(i < n){
                if(!stack.isEmpty()){
                    ans[i] = stack.peek();
                }
            }

            stack.push(element);
        }
        return ans;
    }
}