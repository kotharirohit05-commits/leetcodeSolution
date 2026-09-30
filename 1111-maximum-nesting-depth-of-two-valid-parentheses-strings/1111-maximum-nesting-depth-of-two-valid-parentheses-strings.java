class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;
        
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            
            if (c == '(') {
                // Increment depth first, then assign based on the new depth's parity
                depth++;
                answer[i] = depth % 2;
            } else {
                // Assign based on the current depth's parity, then decrement depth
                answer[i] = depth % 2;
                depth--;
            }
        }
        
        return answer;
    }
}
