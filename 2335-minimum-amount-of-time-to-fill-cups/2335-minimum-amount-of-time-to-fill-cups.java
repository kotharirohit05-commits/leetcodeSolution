class Solution {
    public int fillCups(int[] a) {
        int sum = 0 ;
        sum = a[0] + a[1] + a[2];
        int max = Math.max(a[0] , Math.max(a[1] , a[2]));
        return Math.max((sum+1) / 2 , max);
    }
}