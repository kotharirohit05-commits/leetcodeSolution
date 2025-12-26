class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length  ;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx =  i;
                break;
            }
        }
        if(idx == -1){
            int ini = 0 ;
            int fin = n-1;
            while(ini <= fin ){
                int temp = nums[ini];
                nums[ini] = nums[fin];
                nums[fin] = temp;
                ini++;
                fin--;
            }
            return;

        }
        for(int i = n-1 ; i >= 0 ; i--){
            if(nums[i] > nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        int i1 = idx + 1;
        int f1 = n-1;
        while(i1 <= f1){
            int temp = nums[i1] ;
            nums[i1] = nums[f1];
            nums[f1] = temp;
            i1+=1;
            f1-=1;
        }
    }
}