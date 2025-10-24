class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
         String[] words = text.split(" ");
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean canType = true;

            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (broken.contains(chars[j])) {
                    canType = false;
                    break;
                }
            }

            if (canType) {
                count++;
            }
        }

        return count;
    }
    
}