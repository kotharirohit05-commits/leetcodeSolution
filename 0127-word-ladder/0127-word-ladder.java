class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first , int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!queue.isEmpty()){

            String word = queue.peek().first;
            int level = queue.peek().second;
            queue.remove();

            if(word.equals(endWord)) return level;

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedword = word.toCharArray();
                    replacedword[i] = ch;
                    String newword = new String(replacedword);
                    if(set.contains(newword)){
                        set.remove(newword);
                        queue.add(new Pair(newword, level+1));
                    }
                }
            }
            
            
        }
        return 0;
    }
}