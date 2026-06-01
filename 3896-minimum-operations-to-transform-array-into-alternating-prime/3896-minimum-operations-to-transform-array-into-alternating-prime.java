class Solution {
    public int minOperations(int[] nums) {

        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if( i % 2 == 0){
                int val = nums[i];
                while(!isPrime(val)){
                    val++;
                    count++;
                }
            }else{
                
                if(isPrime(nums[i])){
                    if(nums[i] == 2){
                        count += 2;
                    }else{
                        count += 1;
                    }
                }
            }
        }
            return count;
        
    }

    private boolean isPrime(int a){
        
        if(a <= 1 ) return false;
        for(int i = 2 ; i * i <= a ; i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
        
    }
}
