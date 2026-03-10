class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
        for(int r = 0; r < s.length() ; r++){

            sCount[s.charAt(r) - 'a']++;

            if(r >= p.length()){
                sCount[s.charAt(r - p.length()) - 'a']--;
            }



        if(Arrays.equals(sCount , pCount)){
            ans.add(r - p.length() + 1);
        }
        }
        return ans;
    }
}