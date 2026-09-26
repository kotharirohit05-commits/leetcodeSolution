class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

  Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> innerList = knowledge.get(i);
            map.put(innerList.get(0), innerList.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder currentKey = new StringBuilder();
        boolean inBracket = false;

        // 2. Parse the string in a single pass
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                inBracket = true; // Start capturing the key
            } else if (ch == ')') {
                inBracket = false; // End capturing the key
                String key = currentKey.toString();
                
                // Replace with the map value or "?" if it doesn't exist
                result.append(map.getOrDefault(key, "?"));
                
                // Clear the key buffer for the next bracket pair
                currentKey.setLength(0);
            } else {
                if (inBracket) {
                    currentKey.append(ch); // Build the key
                } else {
                    result.append(ch); // Ordinary character, append directly
                }
            }
        }

        return result.toString();   

    }
}