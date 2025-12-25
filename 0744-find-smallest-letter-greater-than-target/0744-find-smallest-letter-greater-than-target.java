class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int val = target - 'a';
        for(int i = 0 ; i < letters.length ; i++){
            if(letters[i]  > target){
                return letters[i];
            }
            
        }
        return letters[0];
    }
}