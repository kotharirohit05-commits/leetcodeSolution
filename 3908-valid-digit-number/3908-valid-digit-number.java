class Solution {
    public boolean validDigit(int n, int x) {
        boolean first = false;
        boolean second = false;
        String s = String.valueOf(n);
        String small = String.valueOf(x);
        char c = (char)x;

        if(s.contains(small))first = true;
        String[] arr = s.split("");
        if(!small.equals(arr[0])) second = true;

        if(first && second) return true;

        return false;
    }
}