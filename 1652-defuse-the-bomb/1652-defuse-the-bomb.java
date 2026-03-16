class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length + code.length];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = code[i % code.length] ;
        }
        if( k > 0 ){
            for(int i = 0 ;  i < code.length ; i++){
                int sum = 0;
                for(int j = i + 1 ; j <= i + k ; j++){
                    sum += arr[j];
                }
                code[i] = sum;
                
            }
            return code;
        }
        if( k == 0 ){
            for(int i = 0 ;  i < code.length ; i++){
                code[i] = 0;
            }
            return code;
        }
        int r = code.length;
        if( k < 0 ){
            for(int i = code.length  ;  i < arr.length ; i++){
                int sum = 0;
                for(int j = i - 1 ; j >= i + k ; j--){
                    sum += arr[j];
                }
            code[i % code.length] = sum;
            }
            return code;
        }
        return code;
    }
}