class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        int min = max;
        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
        }

        for(int i = 0; i < n; i++){
            if(nums[i] == min ||  nums[i] == max){
                nums[i] = 2;
            }else{
                nums[i] = 0;
            }
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 2){
                left = i + 1;
                break;
            }
        }

        for(int i = n - 1; i >= 0; i--){
            if(nums[i] == 2){
                right = n - i;
                break;
            }
        }

        int ans0 = left + right;

        int ans1 = 0;
        int count = 0;
        while(count <= 2){
            for(int i = 0; i < n; i++){
                if(nums[i] == 2){
                    count++;
                    if(count == 2){
                        ans1 = i + 1;
                        break;
                    }
                  }
                    
                }
            }

        int ans2 = 0;
        int count1 = 0;
        while(count1 <= 2){
            for(int i = n - 1; i >= 0; i--){
                if(nums[i] == 2){
                    count1++;
                    if(count1 == 2){
                        ans2 = n - i;
                        break;
                    }
                  }
                    
                }
            }

        return Math.min(ans2, Math.min(ans1,ans0));
        

    }
}