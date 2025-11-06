class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> mystack = new Stack<>();
        for(int i = 0 ;i < operations.length; i++){
            String ce = operations[i];
        
        if(ce.equals("C")){
            mystack.pop();
        }
        else if(ce.equals("D")){
            mystack.push(mystack.peek() * 2);
        }
        else if(ce.equals("+")){
            int a = mystack.pop();
            int b = mystack.pop();
            int sum = a+b;
            mystack.push(b);
            mystack.push(a);
            mystack.push(sum);
        }
        else{
            int f = Integer.parseInt(ce);
            mystack.push(f);
        }
        }
        int ans = 0;
        while(!mystack.isEmpty() ){
            ans += mystack.pop();
        }
        return ans;
    }
}