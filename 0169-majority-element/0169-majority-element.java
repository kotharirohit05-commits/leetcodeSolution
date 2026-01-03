class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map1= new HashMap<>();
        for(int n : nums){
            map1.put(n,map1.getOrDefault(n , 0) + 1);
        }
        int freq = Integer.MIN_VALUE;
        int ans = 0;
        for(int x : map1.keySet()){
            if(map1.get(x) > freq){
                freq = map1.get(x);
                ans = x;
            }
        }
        return ans;
    }
}