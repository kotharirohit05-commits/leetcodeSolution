class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int n : nums){
            map1.put(n , map1.getOrDefault(n , 0 ) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int s : map1.keySet()){
            if(map1.get(s) > 1){
                res.add(s);
            }
        }
        int[] ans = new int[1];
        for(int i = 0 ; i <= 0 ; i++){
            ans[i] = res.get(i);
        }
        int a = ans[0];
        return a;
    }
}