import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        
        // 1. Keep track of the original index of each query before sorting
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i]; // Query time
            sortedQueries[i][1] = i;          // Original index
        }
        
        // 2. Sort logs and queries by their timestamps
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[qLen];
        int[] serverCounts = new int[n + 1]; // 1-indexed based on constraints
        int distinctServers = 0;
        
        int left = 0;
        int right = 0;
        int m = logs.length;
        
        // 3. Sliding window over the logs
        for (int i = 0; i < qLen; i++) {
            int qTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            
            int startTime = qTime - x;
            int endTime = qTime;
            
            // Expand the right bound of the window
            while (right < m && logs[right][1] <= endTime) {
                int serverId = logs[right][0];
                if (serverCounts[serverId] == 0) {
                    distinctServers++;
                }
                serverCounts[serverId]++;
                right++;
            }
            
            // Shrink the left bound of the window
            while (left < m && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                serverCounts[serverId]--;
                if (serverCounts[serverId] == 0) {
                    distinctServers--;
                }
                left++;
            }
            
            // Total servers minus servers that received at least one request
            ans[originalIdx] = n - distinctServers;
        }
        
        return ans;
    }
}
