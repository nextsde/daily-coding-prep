class Solution:
    def checkValidString(self, S: str) -> bool:
        
        lo, hi = 0, 0
        for char in S:
            lo += 1 if char == '(' else -1
            hi += 1 if char != ')' else -1
            if hi < 0: return False
            lo = max(lo, 0)
        
        return lo == 0
