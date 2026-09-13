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
        int count = 0;
        
        for(int x : map.keySet()){
            List<Integer> adj = map.get(x);
            if(adj.size() == 3){
                int first = adj.get(0);
                int sec = adj.get(1);
                int thi = adj.get(2);
                if((sec - first) == (thi - sec)){
                    count++;
                }
            }
        }

        return count;

    }
}