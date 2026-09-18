class Solution {
    public int countSpecialIntegers(int[] nums) {
        
         HashMap<Integer, List<Integer>> map = new HashMap<>();
  
        for (int i = 0; i < nums.length; i++){
            int element = nums[i];

            if(!map.containsKey(element)){
                map.put(element, new ArrayList<>());
            }

            map.get(element).add(i);       
        }
        int ans = 0;
        
        for(int x : map.keySet()){
            List<Integer> adj = map.get(x);
            int count = 0;
            if(adj.size() >= 3){
                int diff = adj.get(1) - adj.get(0);
                for(int i = 2; i < adj.size(); i++){
                    if(adj.get(i) - adj.get(i - 1) != diff){
                        break;
                    }else{
                        count++;
                    }
                    if(count == adj.size() - 2){
                        ans++;
                    }
                }
            }
        }

        return ans;


    }
}