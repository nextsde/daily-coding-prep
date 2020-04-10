class Solution:
    def longestPalindrome(self, A: str) -> str:
        L = len(A)
        dp = [[False for c in range(L)] for _ in range(L)]
        
        ans = ''
        for i in range(L):
            dp[i][i] = True
            ans = A[i]
        
        for i in range(0, L-1):
            if A[i] == A[i+1]:
                dp[i][i+1] = True
                ans = A[i:i+2]
        
        for k in range(3, L+1):
            for i in range(0, L-k+1):
                j = i+k-1
                if A[i] == A[j] and dp[i+1][j-1]:
                    dp[i][j] = True
                    ans = A[i:j+1]
        
        return ans