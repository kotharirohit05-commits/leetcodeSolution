class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(i == s.length() - 1 || s.charAt(i) != s.charAt(i+1)){
                int length = i - start + 1;
                if(length >= 3){
                    ans.add(Arrays.asList(start,i));
                }
                start = i+ 1;
            }
            
        }
        return ans;
    }
}