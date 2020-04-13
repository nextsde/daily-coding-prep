class Solution:
    def toLowerCase(self, S: str) -> str:
        ans = []
        for s in S:
            #A -> a
            if ord('A') <= ord(s) <= ord('Z'):
                letter = ord(s) - ord('A')
                ans.append(chr(ord('a') + letter))
            else:
                ans.append(s)
        
        return ''.join(ans)