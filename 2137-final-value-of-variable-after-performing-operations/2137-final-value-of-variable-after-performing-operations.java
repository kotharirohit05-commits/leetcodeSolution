class Solution {
    public int finalValueAfterOperations(String[] op) {
        int count = 0;
        for(int i = 0 ; i < op.length ; i++){
            String s = op[i];
            if(s.contains("-")){
                count -= 1;
            }
            else{
                count += 1;
            }
        }
        return count;
    }
}