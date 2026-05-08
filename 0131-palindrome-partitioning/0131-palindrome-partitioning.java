class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(0 , s , curr , res);
        return res;
    }
    private void helper(int ind , String s , List<String> curr , List<List<String>> res ){
        if(ind == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = ind ; i < s.length() ; i++){
            if(isPalimdrome(s , ind , i)){
                curr.add(s.substring(ind ,i+1));                       
                helper(i + 1 , s , curr , res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalimdrome(String s , int start , int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}