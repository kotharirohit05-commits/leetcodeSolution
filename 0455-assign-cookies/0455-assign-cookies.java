class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        boolean arr[] = new boolean[g.length];

        Arrays.fill(arr,true);
        int count = 0;
        int j = 0;
        for(int i = 0 ; i < s.length ; i++){
            if(s[i] >= g[j]){
                count++;
                j++;
                if(j == g.length) break;
            }
        }
        return count;
    }
}