class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        N, M = len(nums1)+1, len(nums2)+1
        
        dp = [[-float('inf') for j in range(N)] for _ in range(M)]

        for i in range(1, M):
            for j in range(1, N):
                dp[i][j] = max(dp[i][j-1], dp[i-1][j], nums1[j-1]*nums2[i-1] + max(dp[i-1][j-1], 0))
        return dp[-1][-1]