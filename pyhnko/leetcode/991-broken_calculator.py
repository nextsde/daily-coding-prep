class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        steps = 0
        while Y > X:
            steps += 1
            if Y&1: Y += 1
            else: Y>>=1
        
        return steps +X-Y