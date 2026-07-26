class Solution {
    public int largestInteger(int n, int s) {
        if(s == 0) return 0;
        if(n * 9 < s) return -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(Math.min(9,s));
            s-=Math.min(9,s);
        }
        return Integer.parseInt(sb.toString());
    }
}