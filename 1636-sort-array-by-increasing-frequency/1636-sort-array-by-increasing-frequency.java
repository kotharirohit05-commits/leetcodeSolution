class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put( i , map.getOrDefault(i , 0 ) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list , (a,b) ->{
            if(map.get(a) != map.get(b)) return map.get(a) - map.get(b);
            else return b-a;
        } );

        int[] res = new int[nums.length];
        int idx = 0;
        for(int i = 0 ; i < list.size() ; i++){
            int num = list.get(i);
            int freq = map.get(num);

            for(int j = 0 ; j < freq ; j++){
                res[idx++] = num;
            }
        }
        return res;
    }
}