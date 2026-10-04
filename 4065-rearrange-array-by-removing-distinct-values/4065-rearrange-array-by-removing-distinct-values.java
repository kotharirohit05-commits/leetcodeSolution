class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int k = 0;
        int[] ans = new int[nums.length];

        while(!map.isEmpty()){
            for(int x: list){
                if(map.containsKey(x)){
                ans[k++] = x;
                
                if(map.get(x) == 1){
                    map.remove(x);
                }else{
                    map.put(x, map.get(x) - 1);
                }    
               }
            }
        }
        return ans;

    }
}