class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);  
            } else {
                int v = stack.pop();     
                int prev = stack.pop();  
                int newScore = prev + Math.max(2 * v, 1);
                stack.push(newScore);
            }
        }

        return stack.pop();
    }
}
