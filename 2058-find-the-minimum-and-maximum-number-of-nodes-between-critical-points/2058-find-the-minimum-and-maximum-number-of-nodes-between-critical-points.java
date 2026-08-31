class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // A critical point requires at least 3 nodes
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        int firstCritical = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;
        
        // Track pointers and positions
        ListNode prevNode = head;
        ListNode currNode = head.next;
        int index = 1; // 0-indexed position
        
        while (currNode.next != null) {
            ListNode nextNode = currNode.next;
            
            // Check for local maxima or local minima
            boolean isMaxima = currNode.val > prevNode.val && currNode.val > nextNode.val;
            boolean isMinima = currNode.val < prevNode.val && currNode.val < nextNode.val;
            
            if (isMaxima || isMinima) {
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    // Minimum distance is always between adjacent critical points
                    minDist = Math.min(minDist, index - prevCritical);
                }
                // Update the last seen critical point
                prevCritical = index;
            }
            
            // Move pointers forward
            prevNode = currNode;
            currNode = nextNode;
            index++;
        }
        
        // If fewer than two critical points were found
        if (firstCritical == prevCritical) {
            return new int[]{-1, -1};
        }
        
        int maxDist = prevCritical - firstCritical;
        return new int[]{minDist, maxDist};
    }
}
