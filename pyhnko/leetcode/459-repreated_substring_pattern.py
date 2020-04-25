class Solution:
    def repeatedSubstringPattern(self, S: str) -> bool:
        curr = ''
        for i, s in enumerate(S[:len(S)]):
            curr = curr + s
            L = len(curr)
            LT = len(S)
            for rep in range(2, 10000):
                if rep*L > LT: break
                if curr*rep == S: return True
        return False