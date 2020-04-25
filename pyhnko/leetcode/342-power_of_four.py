class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        cur = 1
        while cur < num:
            cur *= 4
        
        return cur == num