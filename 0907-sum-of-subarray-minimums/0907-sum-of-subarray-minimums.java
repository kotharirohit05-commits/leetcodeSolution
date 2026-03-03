class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long[] right = new long[n];
        long[] left = new long[n];

        long result = 0;
        long mod = 1000000007;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = i + 1;
            }else{
                left[i] = i - stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n - i;
            }
            else{
                right[i] = stack.peek() - i;
            }
            stack.push(i);
            
        }
        for(int i = 0 ; i < n ; i++){
            result = (result + arr[i] * left[i] * right[i]) % mod;
        }
        return (int)result;
    }
}