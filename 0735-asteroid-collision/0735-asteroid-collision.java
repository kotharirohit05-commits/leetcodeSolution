class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < asteroids.length ; i++){
            int element = asteroids[i];
            if(stack.isEmpty()){
                stack.push(element);
            }
            else if(stack.peek() < 0 || element > 0){
                stack.push(element);
            }
            
            else{
            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -element){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == -element){
                stack.pop();
            }
            else if(stack.isEmpty() || stack.peek() < 0){
                stack.push(element);
            }
        }
        }

        
        int[] res = new int[stack.size()];
        for(int i = res.length - 1 ; i >= 0 ; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}