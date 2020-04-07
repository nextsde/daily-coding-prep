class Solution:
    def numTrees(self, n: int) -> int:
        def count(L, R):
            if L>R: return 1
            if R-L in dp: return dp[R-L]
            total = 0
            for root in range(L, R+1):
                total += count(L, root-1) * count(root+1, R)

            dp[R-L] = total
            return total
        dp = {}
        return count(1, n)
