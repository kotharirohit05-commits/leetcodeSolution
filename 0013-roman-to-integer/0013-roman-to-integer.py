class Solution:
    def romanToInt(self, s: str) -> int:
        rm = {
            'I':1 ,'V':5 ,'X': 10, 'L':50, 'C': 100, 'D' : 500 ,'M' : 1000
        }
        total = 0
        for i in range(len(s) - 1):
            if rm[s[i]] < rm[s[i+1]]:
                total -= rm[s[i]]
            else:
                total += rm[s[i]]

        total += rm[s[-1]]        
        return total            
