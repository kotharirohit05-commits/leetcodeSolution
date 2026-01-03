class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int n : nums){
            if(n % 2 == 0){
            map1.put(n,map1.getOrDefault(n,0) + 1);
            }
        }
        int maxFreq = Integer.MIN_VALUE;
        int ans = -1;
        for(int x : map1.keySet()){
            int freq = map1.get(x);
            if(freq > maxFreq || (freq == maxFreq && x < ans) ){
                maxFreq = freq;
                ans = x;
            }
        }
        return ans;
        

    }
}