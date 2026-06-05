class Solution {
    public long sumOfLargestPrimes(String s) {

     
        HashSet<Long> set = new HashSet<>();

        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                long x = Long.parseLong(s.substring(i, j + 1));
                if(isPrime(x)){
                    set.add(x);
                    
                }
            }
        }
           List<Long> list = new ArrayList<>(set);
        list.sort((a,b) -> Long.compare(b,a));
        
        long sum = 0;
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            sum += list.get(i);
        }
        return sum;
    }
    private boolean isPrime(long x){
        if( x < 2) return false;
        for(long i = 2 ; i*i <= x ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}