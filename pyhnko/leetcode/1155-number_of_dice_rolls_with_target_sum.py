class Solution:
    def numRollsToTarget(self, D: int, F: int, target: int) -> int:
        def dice(d, target):
            
            if d == 0 and target == 0: return 1
            if d == 0 or target <= 0: return 0
            if (d, target) in dp: return dp[(d, target)]
            
            ans = 0
            for move in range(1, F+1):
                if move <= target:
                    ans = (ans + dice(d-1, target-move))%(10**9+7)
                else: break
            
            dp[(d, target)] = ans
            
            return ans
        
        dp = {}
        return dice(D, target)