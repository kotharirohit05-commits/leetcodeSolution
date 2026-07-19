class Solution {
    public boolean canReach(int[] start, int[] target) {
        int first = Math.abs(target[0] - start[0]);
        int second = Math.abs(target[1] - start[1]);
        if((first + second) % 2 == 0 ) return true;
        return false;

    }
}