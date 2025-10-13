class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> part = new ArrayList<>();
        getpart(s , part , ans);
        return ans ;
        
    }
    public static void getpart(String s , List<String> part , List<List<String>> ans){
        if(s.length() == 0) {
        ans.add(new ArrayList<>(part));
        return ;
        }
        for(int i = 0; i < s.length()  ; i++){
            String prefix = s.substring(0,i+1);
            if(isPalin(prefix)){
                part.add(prefix);
                getpart(s.substring(i+1) ,part , ans);
                part.remove(part.size() - 1);
            }
        }
    }
    public static boolean isPalin(String s){
        
        int i = 0 ; 
        int j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}