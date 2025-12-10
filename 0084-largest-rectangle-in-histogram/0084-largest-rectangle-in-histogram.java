class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] rs = new int[heights.length];
        int[] ls = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            rs[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            ls[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int width = rs[i] - ls[i] - 1;
            int currea = heights[i] * width;
            ans = Math.max(ans,currea);
        }
        return ans;
    }
}