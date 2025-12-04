class Solution {
    public String makeGood(String s) {
        Stack<Character> mystack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!mystack.isEmpty() && Math.abs(mystack.peek() - c) == 32){
                mystack.pop();
            }
            else{
                mystack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : mystack){
            sb.append(c);
        }
        return sb.toString();

    }
}