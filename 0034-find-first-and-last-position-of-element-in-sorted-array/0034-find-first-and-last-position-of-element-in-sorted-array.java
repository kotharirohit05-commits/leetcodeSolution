class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = flb(nums,target);
        int right = frb(nums,target);
        return new int[]{left,right};
    }

    private int flb(int[] nums , int target){
        int low = 0 , index = -1 , high = nums.length - 1 ;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                index = mid;
                high = mid - 1;
            }
            else if ( nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return index;
    }
    private int frb(int[] nums , int target){
        int low = 0 , index = -1 , high = nums.length - 1 ;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                index = mid;
                low = mid + 1;
            }
            else if ( nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return index;

    }
    
    
}