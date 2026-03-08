class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n =  nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            int number = Integer.parseInt(nums[i] , 2);
            map.put(number , map.getOrDefault(number , 0) + 1);
        }
        int a = 0;
        int range = (int)Math.pow(2,nums.length);
        for(int i = 0 ; i < range ; i++){
            if(!map.containsKey(i)){
                String ans = Integer.toBinaryString(i);
                while(ans.length() < n ){
                    ans = "0" + ans;
                }
                return ans;
            }

        }return "";
    }
}