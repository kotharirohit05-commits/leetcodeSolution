class Solution {
    public double minPrice(int[] prices, int[] discounts) {

        Arrays.sort(prices);
        Arrays.sort(discounts);
        int s = 0;
        int e = prices.length - 1;

        while(s < e){
            int temp = prices[s];
            prices[s] = prices[e];
            prices[e] = temp;
            s++;
            e--;
        }

        int s1 = 0;
        int e1 = discounts.length - 1;
        while(s1 < e1){
            int temp = discounts[s1];
            discounts[s1] = discounts[e1];
            discounts[e1] = temp;
            s1++;
            e1--;
        }
        
        double ans = 0;
        int idx = 0;

        for(int i = 0; i < prices.length; i++){
            if(idx < Math.min(prices.length, discounts.length)){
                ans += (double) (prices[idx] * (100 - discounts[idx])) / 100;
                idx++;
            }else{
                ans += prices[i];
            }
        }
       return ans;
    }
}