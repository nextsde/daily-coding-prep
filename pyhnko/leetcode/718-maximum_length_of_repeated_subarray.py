class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        dp = [[0 for c in range(len(B)+1)] for r in range(len(A)+1)]
        ans = 0
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if A[i-1] == B[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                ans = max(ans, dp[i][j])
               
        return ans