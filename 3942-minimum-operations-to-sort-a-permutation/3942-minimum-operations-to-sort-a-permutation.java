class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        int targetShift0 = getTargetShift(nums);
        
        int[] revNums = new int[n];
        for (int i = 0; i < n; i++) {
            revNums[i] = nums[n - 1 - i];
        }
        int targetShift1 = getTargetShift(revNums);
        
        if (targetShift0 == -1 && targetShift1 == -1) {
            return -1;
        }
        
        int targetId0 = (targetShift0 != -1) ? (0 * n + targetShift0) : -1;
        int targetId1 = (targetShift1 != -1) ? (1 * n + targetShift1) : -1;
        
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[2 * n];
        Arrays.fill(dist, -1);
        
        queue.offer(0);
        dist[0] = 0;
        
        while (!queue.isEmpty()) {
            int currId = queue.poll();
            
            if (currId == targetId0 || currId == targetId1) {
                return dist[currId];
            }
            
            int type = currId / n;
            int shift = currId % n;
            
            
            int nextShiftRot = (shift + 1) % n;
            int nextIdRot = type * n + nextShiftRot;
            if (dist[nextIdRot] == -1) {
                dist[nextIdRot] = dist[currId] + 1;
                queue.offer(nextIdRot);
            }
            
            
            int nextTypeRev = 1 - type;
            int nextShiftRev = (n - shift) % n;
            int nextIdRev = nextTypeRev * n + nextShiftRev;
            if (dist[nextIdRev] == -1) {
                dist[nextIdRev] = dist[currId] + 1;
                queue.offer(nextIdRev);
            }
        }
        
        return -1;
    }
    
    private int getTargetShift(int[] arr) {
        int n = arr.length;
        int zeroPos = -1;
        
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroPos = i;
                break;
            }
        }
        
        
        for (int j = 0; j < n; j++) {
            if (arr[(zeroPos + j) % n] != j) {
                return -1;
            }
        }
        
        
        return zeroPos;
    }
}
