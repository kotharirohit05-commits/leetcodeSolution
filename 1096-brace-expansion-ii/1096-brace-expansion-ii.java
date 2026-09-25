import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Object> stack = new Stack<>();
        int i = 0;
        int n = expression.length();

        while (i < n) {
            char ch = expression.charAt(i);

            if (Character.isLetter(ch)) {
                // Extract the full consecutive word block
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isLetter(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--; // Step back to counter the extra increment in the while loop

                Set<String> currSet = new HashSet<>();
                currSet.add(sb.toString());

                // Implicit concatenation: if the top of the stack is a Set, cross-multiply
                if (!stack.isEmpty() && stack.peek() instanceof Set) {
                    Set<String> prevSet = (Set<String>) stack.pop();
                    currSet = mergeSets(prevSet, currSet);
                }
                stack.push(currSet);

            } else if (ch == '{') {
                stack.push('{');

            } else if (ch == ',') {
                stack.push(',');

            } else if (ch == '}') {
                // Collect and union all comma-separated groups inside the current braces
                Set<String> combinedSet = new HashSet<>();
                while (!stack.isEmpty() && !stack.peek().equals('{')) {
                    Object top = stack.pop();
                    if (!top.equals(',')) {
                        combinedSet.addAll((Set<String>) top);
                    }
                }
                
                // Pop the matching opening brace '{'
                stack.pop();

                // Implicit concatenation: if the element before '{' was a Set, cross-multiply
                if (!stack.isEmpty() && stack.peek() instanceof Set) {
                    Set<String> prevSet = (Set<String>) stack.pop();
                    combinedSet = mergeSets(prevSet, combinedSet);
                }
                stack.push(combinedSet);
            }
            i++;
        }

        // Final step: union everything remaining in the stack
        Set<String> finalSet = new HashSet<>();
        while (!stack.isEmpty()) {
            Object top = stack.pop();
            if (top instanceof Set) {
                finalSet.addAll((Set<String>) top);
            }
        }

        // Sort alphabetically as required by the problem statement
        List<String> result = new ArrayList<>(finalSet);
        Collections.sort(result);
        return result;
    }

    // Helper method to compute the Cartesian product (concatenation) of two sets
    private Set<String> mergeSets(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>();
        for (String str1 : s1) {
            for (String str2 : s2) {
                result.add(str1 + str2);
            }
        }
        return result;
    }
}
