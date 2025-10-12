class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        getcomb(arr , 0 ,target ,comb , ans );
        return ans;
    }
    public static void getcomb(int[] arr,int  i ,int target ,List<Integer> comb ,List<List<Integer>> ans){
        if(i == arr.length || target < 0){
            return ;
        }
        if(target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        comb.add(arr[i]);
        
        getcomb(arr , i , target-arr[i] , comb , ans);
        comb.remove(comb.size() - 1);
        int next = i+1;
        while(next < arr.length && arr[next] == arr[i]) next++;
        getcomb(arr , next , target , comb , ans);
    }
}