class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return cost[0] + cost[1];
        if(cost.length == 3) return cost[2] + cost[1];
        
        int sum = 0;
        for(int i = 0 ; i < cost.length; i++){
            sum += cost[i];
        }int sub = 0;
        for(int i = cost.length - 3 ; i >= 0 ; i -= 3){
            sub += cost[i];
        }
        return sum - sub;

    }
}