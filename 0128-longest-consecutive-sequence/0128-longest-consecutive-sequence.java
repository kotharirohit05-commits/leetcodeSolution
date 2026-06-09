class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int count = 0;
        int max = 0;
        for(int x : set){
            if(!set.contains(x-1)){
                int len = 1;
                int curr = x;
            
            while(set.contains(curr + 1)){
                len++;
                curr++;
            }
            
            max = Math.max(len , max);
            }
        }
        return max;

    }
}