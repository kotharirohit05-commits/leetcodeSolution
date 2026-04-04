class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
        int l = flower.length;

        for(int i = 0 ; i < l; i++){
            if(flower[i]  == 0){
                boolean left =  (i==0) || (flower[i-1] == 0) ;
                boolean right = (i== l - 1) || (flower[i+1] == 0)  ;

                if(left && right){
                    flower[i] = 1;
                    n--;
                    if(n <= 0) return true;
                }
            }

             
        }
       
        return n<=0;
    }
}