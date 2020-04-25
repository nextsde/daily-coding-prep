class Solution:
    def longestPalindrome(self, A: str) -> str:
        if not A: return ''
        
        L = len(A)
        dp = [[0 for j in range(L)] for i in range(L)]
        
        ans = ''
        for i in range(L): 
            dp[i][i] = 1
            ans = A[i]
        
        for i in range(L-1):
            if A[i] == A[i+1]: 
                dp[i][i+1] = 1
                ans = A[i:i+2]
        
        for k in range(3, L+1):
            for i in range(0, L-k+1):
                j = i+k-1
                
                if A[i] == A[j] and dp[i+1][j-1]:
                    dp[i][j] = 1
                    ans = A[i:j+1]
        
        return ans