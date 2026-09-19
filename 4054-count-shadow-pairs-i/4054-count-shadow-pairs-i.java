class Solution {
    public long shadowPairs(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        long ans = 0;

        for(int x : nums){

            int count = getPosition(list, x);
            ans += count;

            while(!list.isEmpty() && list.get(list.size() - 1) > x ){
                list.remove(list.size() - 1);
            }

            list.add(x);

        }
        
        return ans;

    }

    private int getPosition(List<Integer> list, int num){

        int left = 0;
        int right = list.size() ;
        while(left < right){
            int mid = left + ( right - left ) / 2;
            if(list.get(mid) >= num){
                right = mid ;
            }else{
                left = mid + 1;
            }
        }
        return left;

    }

}