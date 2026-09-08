class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        # Frequency map for characters in t
        freq = Counter(t)
        
        left = 0
        count = 0
        min_len = float('inf')  # Equivalent to Integer.MAX_VALUE
        s_index = 0
        
        for right in range(len(s)):
            ch = s[right]
            
            # If the character is needed in the current window
            if freq[ch] > 0:
                count += 1
                
            freq[ch] -= 1
            
            # Try to shrink the window from the left
            while count == len(t):
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    s_index = left
                    
                left_char = s[left]
                freq[left_char] += 1
                
                # If a required character leaves the window fully
                if freq[left_char] > 0:
                    count -= 1
                    
                left += 1
                
        # Return empty string if no window found, otherwise return the substring slice
        return "" if min_len == float('inf') else s[s_index : s_index + min_len]
