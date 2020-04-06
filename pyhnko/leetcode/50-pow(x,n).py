class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: return 1

        if n < 0:
            x = 1/x
            n = -n

        ans = 1
        while n:
            if n&1:
                ans *= x
            x = x*x
            n//=2

        return ans
            
