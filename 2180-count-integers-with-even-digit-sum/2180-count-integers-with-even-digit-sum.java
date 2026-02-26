class Solution {
    public int countEven(int num) {
       int count = 0 ;
       for(int i = 1 ; i <= num ; i++){
        if(isValid(i)){
            count++;
        }
       } 
       return count;
    }
    private boolean isValid(int i){
        int sum = 0;
        while(i > 0){
            int dig = i % 10;
            sum += dig;
            i /= 10;
        }
        if(sum % 2 == 0) return true;
        return false;

    }
}