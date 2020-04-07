class Solution:
    def climbStairs(self, n: int) -> int:
        def climb(idx):
            if idx == n: return 1
            elif idx >n: return 0

            elif idx in dp: return dp[idx]

            ans = climb(idx+1) + climb(idx+2)
            dp[idx] = ans
            return ans

        dp = {}
        return climb(0)
