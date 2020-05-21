""" O(N^2)
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
        
        return ans """

class Solution: # O(N)
    def longestPalindrome(self, A: str) -> str:
        if len(A) < 2: return A
        
        def manacher(A):
            A = '#' + '#'.join(A) + '#'
            P = [0]*len(A)
            
            center = 0
            right_boundary = 0
            for i in range(len(A)):
                mirror = center - (i - center)
                
                if i < right_boundary: P[i] = min(P[mirror], right_boundary-i)
                
                r = i + (P[i] + 1)
                l = i - (P[i] + 1)
                
                while l >= 0 and r < len(A) and A[l] == A[r]:
                    P[i] += 1
                    l-=1; r+=1;
                
                if i + P[i] > right_boundary:
                    center = i
                    right_boundary = i + P[i]
            length = max(P)
            idx    = P.index(length) 
            return ''.join(A[idx-length+1: idx+length].split('#'))
        
        return manacher(A)
            
        
        