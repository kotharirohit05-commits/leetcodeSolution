class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long maxAmongTwo = Math.max(need1,need2);
        long minAmongTwo = Math.min(need1,need2);

        long remaning1 = need1 - minAmongTwo;
        long remaning2 = need2 - minAmongTwo;

        long AnsByMult = (long)need1*cost1 + (long)need2*cost2;
        long BuyingBoth = maxAmongTwo*(long)costBoth;
        long BuyingOne = minAmongTwo*costBoth + remaning1 * cost1 + remaning2 * cost2;
        long ans = Math.min(AnsByMult,Math.min(BuyingBoth,BuyingOne));
        return ans;

    }
}