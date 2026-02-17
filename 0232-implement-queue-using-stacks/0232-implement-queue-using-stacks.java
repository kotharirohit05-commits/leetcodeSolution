class MyQueue {
    Stack<Integer> inputstack;
    Stack<Integer> outputstack;
    public MyQueue() {
        inputstack = new Stack<>();
        outputstack = new Stack<>();
    }
    
    public void push(int x) {
        inputstack.push(x);
    }
    
    public int pop() {
        if(outputstack.isEmpty()){
            while(!inputstack.isEmpty()){
                int val = inputstack.pop();
                outputstack.push(val);
         }
        }
        return outputstack.pop();
    }
    
    
    public int peek() {
        if(outputstack.isEmpty()){
            while(!inputstack.isEmpty()){
                int val = inputstack.pop();
                outputstack.push(val);
         }
        }
        return outputstack.peek();
    }
    
    public boolean empty() {
        return (outputstack.isEmpty() && inputstack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */