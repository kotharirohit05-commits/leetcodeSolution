class Solution {
    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <='z')continue;
            else{
                int x = c - '0';
                set.add(x);
            }
            
        }
        if(set.size() <= 1) return -1;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(set.size() - 1 - 1);
    }
}