class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int n : nums){
            hm.put(n,hm.getOrDefault(n , 0) + 1 );
        }
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }
}