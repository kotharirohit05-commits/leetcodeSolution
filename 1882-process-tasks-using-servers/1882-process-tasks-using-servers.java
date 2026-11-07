import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // freeServers: ordered by weight, then by index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // busyServers: ordered by freeTime, then by weight, then by index
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        // Initialize all servers as free
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        int currTime = 0;

        for (int j = 0; j < m; j++) {
            // Advance time to at least the arrival time of the current task
            currTime = Math.max(currTime, j);

            // If no servers are available, fast-forward time to the next available server's free time
            if (freeServers.isEmpty()) {
                currTime = Math.max(currTime, busyServers.peek()[0]);
            }

            // Release all servers that finished their tasks by the current time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] server = busyServers.poll();
                freeServers.offer(new int[]{server[1], server[2]}); // weight, index
            }

            // Allocate the task to the best free server
            int[] bestServer = freeServers.poll();
            int weight = bestServer[0];
            int idx = bestServer[1];

            ans[j] = idx;

            // Mark server as busy: {freeTime, weight, index}
            busyServers.offer(new int[]{currTime + tasks[j], weight, idx});
        }

        return ans;
    }
}
