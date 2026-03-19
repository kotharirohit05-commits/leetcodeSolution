class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < k ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }
        int left = 0;
        for(int r = k ; r <= nums.length ; r++){
            ans[left] = getismax(map , x);

            if(r == nums.length) break;
            int leftval = nums[left];
            map.put(leftval , map.get(leftval) - 1);
            if(map.get(leftval) == 0){
                map.remove(leftval);
            }



            map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1);
            left++;
        }
        return ans;

    }
    private int getismax(HashMap<Integer,Integer> map , int x){
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list , (a,b) ->{
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA != freqB){
                return freqB - freqA;
            }
            return b - a;
        });

        int sum = 0 ;
        int count = 0;
        for(int key : list){
            if(count == x) break;
            sum += key * (map.get(key));
            count++;
        }
        return sum;
    }
}