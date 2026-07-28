import java.util.Arrays;

class Solution { 
    public String smallestPalindrome(String s) { 
        int n = s.length(); 
        if(n == 1) return s; 

        StringBuilder sb1 = new StringBuilder(); 
        StringBuilder ans = new StringBuilder(); 
        
        // 1. Count the character frequencies since s is already a palindrome
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // 2. Put exactly half of each character type into sb1 (handles alphabetical ordering naturally)
        char middleChar = 0;
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('a' + i);
            
            // If a character has an odd count, it belongs exactly in the middle
            if (counts[i] % 2 != 0) {
                middleChar = currentChar;
            }
            
            // Take exactly half of this character's occurrences for the first half
            for (int j = 0; j < counts[i] / 2; j++) {
                sb1.append(currentChar);
            }
        }

        // 3. Reconstruct your str and str2 variables matching your original approach
        String str = sb1.toString(); 
        
        // str2 is just str reversed to maintain the perfect palindrome symmetry
        String str2 = new StringBuilder(str).reverse().toString(); 

        // 4. Combine them (including the middle character if the string length is odd)
        ans.append(str); 
        if (middleChar != 0) {
            ans.append(middleChar);
        }
        ans.append(str2); 
        
        return ans.toString(); 
    } 
}
