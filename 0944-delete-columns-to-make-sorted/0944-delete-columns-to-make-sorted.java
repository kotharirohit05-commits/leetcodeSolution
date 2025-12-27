class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length ;
        int col = strs[0].length();
        int count = 0;
        for(int j = 0 ; j < col ; j++){
            for(int i = 1 ; i < rows ; i++){
                if(strs[i].charAt(j) < strs[i-1].charAt(j)){
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}