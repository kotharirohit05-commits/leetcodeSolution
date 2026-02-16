class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int initial = 0 ;
        for(int i : nums){
            initial = initial | i; 
        }
        List<List<Integer>> Finallist = new ArrayList<>();
        int iterate = 1 << nums.length ;
        for(int i = 0 ; i < iterate ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < nums.length ; j++){
                if((i & ( 1 << j)) != 0){
                    list.add(nums[j]);
                }
            }
            Finallist.add(list);
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < Finallist.size() ; i++){
            List<Integer> subList = Finallist.get(i);
            int res = 0;
            for(int j = 0 ; j < subList.size() ; j++ ){
                res |= subList.get(j);
            }
            if(res >= initial){
                count++;
            }
        }
        return count;
    }
}