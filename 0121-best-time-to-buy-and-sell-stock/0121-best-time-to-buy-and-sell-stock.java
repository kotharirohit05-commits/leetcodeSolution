class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minp = Integer.MAX_VALUE;
        for(int i = 0 ; i < prices.length ; i++){
            int price = prices[i];
            if(price < minp){
                minp = price;
            }else{
                max = Math.max(max , price- minp);
            }
            
        }
        return max;
    }
}