class SegmentTree:
    def __init__(self, n: int):
        self.n = n
        self.sum1 = [0] * (4 * n)  # Tracks the sum of elements: sum(d[i])
        self.sum2 = [0] * (4 * n)  # Tracks the sum of squares: sum(d[i]^2)
        self.lazy = [0] * (4 * n)  # Tracks range increments
        self.MOD = 10**9 + 7

    def _push_down(self, node: int, start: int, end: int):
        if self.lazy[node] == 0:
            return
        
        lazy_val = self.lazy[node]
        mid = (start + end) // 2
        left_child = 2 * node
        right_child = 2 * node + 1
        
        # Update left child
        left_len = mid - start + 1
        self.sum2[left_child] = (self.sum2[left_child] + 2 * lazy_val * self.sum1[left_child] + lazy_val * lazy_val * left_len) % self.MOD
        self.sum1[left_child] = (self.sum1[left_child] + lazy_val * left_len) % self.MOD
        self.lazy[left_child] = (self.lazy[left_child] + lazy_val) % self.MOD
        
        # Update right child
        right_len = end - mid
        self.sum2[right_child] = (self.sum2[right_child] + 2 * lazy_val * self.sum1[right_child] + lazy_val * lazy_val * right_len) % self.MOD
        self.sum1[right_child] = (self.sum1[right_child] + lazy_val * right_len) % self.MOD
        self.lazy[right_child] = (self.lazy[right_child] + lazy_val) % self.MOD
        
        self.lazy[node] = 0

    def update(self, node: int, start: int, end: int, l: int, r: int, val: int):
        if l <= start and end <= r:
            length = end - start + 1
            # Using algebra: (d + val)^2 = d^2 + 2 * val * d + val^2
            self.sum2[node] = (self.sum2[node] + 2 * val * self.sum1[node] + val * val * length) % self.MOD
            self.sum1[node] = (self.sum1[node] + val * length) % self.MOD
            self.lazy[node] = (self.lazy[node] + val) % self.MOD
            return
        
        self._push_down(node, start, end)
        mid = (start + end) // 2
        if l <= mid:
            self.update(2 * node, start, mid, l, r, val)
        if r > mid:
            self.update(2 * node + 1, mid + 1, end, l, r, val)
            
        self.sum1[node] = (self.sum1[2 * node] + self.sum1[2 * node + 1]) % self.MOD
        self.sum2[node] = (self.sum2[2 * node] + self.sum2[2 * node + 1]) % self.MOD


class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        n = len(nums)
        MOD = 10**9 + 7
        tree = SegmentTree(n)
        
        last_seen = {}
        total_ans = 0
        
        for j in range(n):
            x = nums[j]
            # Find the last 0-indexed position this element was seen
            last_idx = last_seen.get(x, -1)
            
            # The distinct elements count increments by 1 for all subarrays 
            # starting from index (last_idx + 1) up to the current index j
            tree.update(1, 0, n - 1, last_idx + 1, j, 1)
            
            # tree.sum2[1] holds the sum of squares of distinct element counts 
            # for all subarrays ending at the current index j
            total_ans = (total_ans + tree.sum2[1]) % MOD
            
            # Cache the latest position of this element
            last_seen[x] = j
            
        return total_ans
