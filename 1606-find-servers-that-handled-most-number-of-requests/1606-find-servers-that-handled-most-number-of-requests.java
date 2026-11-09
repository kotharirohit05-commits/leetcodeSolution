import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Track the number of requests each server handles
        int[] requestCount = new int[k];
        
        // Min-heap to store servers currently working: [free_time, server_id]
        // Sorted primarily by free_time, then by server_id
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        // TreeSet to maintain the sorted IDs of currently available servers
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            int duration = load[i];
            
            // 1. Release all servers that finished their tasks by the current arrival time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= start) {
                int[] freeServer = busyServers.poll();
                available.add(freeServer[1]);
            }
            
            // If no servers are available, the request is dropped
            if (available.isEmpty()) {
                continue;
            }
            
            // 2. Find the best server starting from (i % k)
            int target = i % k;
            Integer chosenServer = available.ceiling(target);
            
            // If no server >= target, wrap around to the smallest available server ID
            if (chosenServer == null) {
                chosenServer = available.first();
            }
            
            // 3. Assign the request to the chosen server
            available.remove(chosenServer);
            requestCount[chosenServer]++;
            busyServers.offer(new int[]{start + duration, chosenServer});
        }
        
        // 4. Find the max requests handled and gather all matching server IDs
        int maxRequests = 0;
        for (int count : requestCount) {
            maxRequests = Math.max(maxRequests, count);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}
