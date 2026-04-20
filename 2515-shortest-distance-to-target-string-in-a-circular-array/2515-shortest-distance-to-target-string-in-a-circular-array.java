class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int ans = Integer.MAX_VALUE;
        int n = words.length;

        for(int i = 0 ; i < words.length ; i++){
            if(words[i].equals(target)){
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff , n - diff);
                ans = Math.min(ans , dist);
            }
        }
        return ans == Integer.MAX_VALUE ?  -1 : ans;

    }
}