class Solution:
    def toGoatLatin(self, S: str) -> str:
        ans = []
        for i, s in enumerate(S.split(),1):
            if s[0] in 'aeiouAEIOU':
                ans.append(s + 'ma')
            else:
                char = s[0]
                ans.append(s[1:] + char + 'ma')
            
            ans[-1] = ans[-1] + 'a'*i
        
        return ' '.join(ans)