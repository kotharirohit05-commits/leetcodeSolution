class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int n = s.length();
        boolean all = true;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != s.charAt(i)){
                all = false;
            }
        }
        if(all) return 0;
        if(s.charAt(0) == arr[0] || s.charAt(n-1) == arr[n-1]){
            return 1;
        }
        else{
            if(n == 2) return -1;
            int a = -1 , b = -1;
            for(int i = 0 ; i < n ; i++){
                if(a == -1 && s.charAt(i) == arr[0]){
                    a = i;
                }
                if(s.charAt(i) == arr[n-1]){
                    b = i;
                }
            }
            if(  b == 0  && a == n-1 )   {
                return 3;
            }else{
            return 2;
            }
        }
    }
}