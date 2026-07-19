import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];

        // Store the last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Skip if already in stack
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}