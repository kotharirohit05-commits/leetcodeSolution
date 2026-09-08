class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        freq = Counter(t)
        
        left = 0
        count = 0
        min_len = float('inf')  
        s_index = 0
        
        for right in range(len(s)):
            ch = s[right]
            
            if freq[ch] > 0:
                count += 1
                
            freq[ch] -= 1
            
            while count == len(t):
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    s_index = left
                    
                left_char = s[left]
                freq[left_char] += 1
                
                if freq[left_char] > 0:
                    count -= 1
                    
                left += 1
                
        return "" if min_len == float('inf') else s[s_index : s_index + min_len]
