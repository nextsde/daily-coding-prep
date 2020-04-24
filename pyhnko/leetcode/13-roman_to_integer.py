class Solution:
    def romanToInt(self, s: str) -> int:
        d = {
                'I': 1,
                'V': 5,
                'X': 10,
                'L': 50,
                'C': 100,
                'D': 500,
                'M': 1000
        }
        if len(s) == 1: return d[s]
        
        ans = 0
        i = 0
        while i<len(s)-1:
            if d[s[i]] >= d[s[i+1]]:
                ans += d[s[i]]
                i += 1
            else:
                ans += (d[s[i+1]] - d[s[i]])
                i += 2
        
        if d[s[-1]] <= d[s[-2]]: ans += d[s[-1]]
        
        return ans