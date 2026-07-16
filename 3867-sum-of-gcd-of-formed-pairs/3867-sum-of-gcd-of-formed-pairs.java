class Solution {
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {

        int n = nums.length;
        int max = 0;
        
        int[] prefg = new int[n];
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]); 
            prefg[i] = gcd(nums[i] , max); 
            System.out.println(prefg[i]);
        }

        int left = 0;
        int right = n-1;
        long ans = 0;
        Arrays.sort(prefg);
        
        while(left < right){

            ans += gcd(prefg[left], prefg[right]);
            left++;
            right--;

        }
        
        return ans;

    }
}