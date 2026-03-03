class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        for(int i = 2 ; i <= n ; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = sb.length() - 1 ; j >= 0 ; j--){
                char c = sb.charAt(j);
                temp.append(c == '0' ? '1' : '0');
            }
            sb.append("1");
            sb.append(temp);
        }
        
        return sb.charAt(k-1);

    }
}