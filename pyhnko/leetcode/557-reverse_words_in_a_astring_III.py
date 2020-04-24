class Solution:
    def reverseWords(self, S: str) -> str:
        ans = []
        for s in S.split():
            s = list(s)
            l, r = 0, len(s)-1
            while l < r:
                s[l], s[r] = s[r], s[l]
                l, r = l+1, r-1
            
            ans.append(''.join(s))
        
        return ' '.join(ans)