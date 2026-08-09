class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else{
                int low = 0;
                int high = list.size() - 1;
                while(low <= high){
                    int mid = low + (high - low) / 2;
                    if(list.get(mid) >= nums[i]){
                        high = mid - 1;
                    }else if(list.get(mid) < nums[i]){
                        low = mid + 1;
                    }
                    
                     
                }
                list.set(low, nums[i]);
                 

            }
           
        }   
        return list.size();

    }
}