class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        cnt = 0
        ans = []
        for s in S:
            cnt += 1 if s == '(' else -1
            if cnt == 1 and s == '(' or cnt == 0: continue
            
            ans.append(s)
        
        return ''.join(ans)