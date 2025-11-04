class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toUpperCase())) return true;
        if(word.equals(word.toLowerCase())) return true;
        char first = word.charAt(0);
        String rest = word.substring(1);
        if(Character.isUpperCase(first) && rest.equals(rest.toLowerCase())) return true;

        return false;
    }
}