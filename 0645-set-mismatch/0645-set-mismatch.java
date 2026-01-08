class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1);
        }
        int dup = 0;
        int sum =0;
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(freq == 2){
                dup = i;
            }
        }
        int dash = 0;
        for(int i = 1 ; i <= n ; i++){
            if(!map.containsKey(i)){
                dash = i;
            }
        }


        

        return new int[]{dup, dash};
    }
}