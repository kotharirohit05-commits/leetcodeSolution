class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int n : nums1){
            map1.put(n , map1.getOrDefault(n , 0 ) + 1);
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int n : nums2){
            map2.put(n , map2.getOrDefault(n , 0 ) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                int times = Math.min(map1.get(key) , map2.get(key));
                for(int i = 0 ; i < times ; i++){
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        
        for(int i  = 0 ; i < res.length ; i++){
            res[i] = list.get(i);
        }
        return res;
        
    }
}