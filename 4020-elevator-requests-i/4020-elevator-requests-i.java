class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int sum = 0;
        int time = 0;
        int curr = 0;

        for(int x : requests){
           
           time = Math.abs(x - curr);
           curr = x;
           sum += time;
            

        }
        return sum;
        
    }
}