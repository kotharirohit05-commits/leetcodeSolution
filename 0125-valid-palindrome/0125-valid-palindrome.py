class Solution:
    def isPalindrome(self, s: str) -> bool:
        empty =""
        for char in s:
            if char.isalnum():
                empty += char.lower()
        reversed = empty[::-1]
        if reversed == empty:
            return True
        return False        