class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        generate(0 , nums , ans);
        return ans;
    }
    public void generate(int index , int[] nums , List<List<Integer>>ans){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++){
                temp.add(nums[i]);
            }
            ans.add(temp);
        }

        for(int i = index ; i < nums.length ; i++){

            int temp = nums[index] ; 
            nums[index] = nums[i] ;
            nums[i] = temp;
            generate(index + 1 , nums , ans);
            
            temp = nums[index] ;
            nums[index] = nums[i] ;
            nums[i] = temp;
        }
    }
}