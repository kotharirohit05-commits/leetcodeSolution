class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list , (a,b) -> {
            if(map.get(a) != map.get(b)) return map.get(b) - map.get(a);
            else return a-b;
        });
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            
            res[i] = list.get(i);;
        }
        return res;

    }
}