class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        while(n > 0){
            int p = n % 10;
            freq[p]++;
            n = n/10;
        }
        int sum = 0;
        for(int i = 0 ; i < 10 ; i++){
            int sub = i * freq[i];
            sum += sub;
        }
        return sum;
    }
}