class Solution_N2:
    def countSubstrings(self, S: str) -> int:
        N = len(S)
        dp = [[False for j in range(N)] for i in range(N)]
        
        # one character
        for i in range(N): dp[i][i] = True
        
        # two characters
        for i in range(N-1):
            if S[i] == S[i+1]: 
                dp[i][i+1] = True
        
        # three or more
        for k in range(3, N+1):
            for i in range(0, N-k+1):
                j = i+k-1
                if S[i] == S[j] and dp[i+1][j-1] == True:
                    dp[i][j] = True
        
        return sum(1 for i in range(N) for j in range(N) if dp[i][j] == True)

class Solution_N:
    def countSubstrings(self, S: str) -> int:
        S = '#' + '#'.join(S) + '#'
        P = [0] * len(S)
        
        center = right_boundary = 0
        for i in range(len(S)):
            mirror = center - (i - center)
            
            if i < right_boundary: P[i] = min(P[mirror], right_boundary - i)
            
            r = i + (P[i] + 1)
            l = i - (P[i] + 1)

            while l>= 0 and r<len(S) and S[l] == S[r]:
                P[i] += 1
                l-=1; r+=1;
            if i + P[i] > right_boundary:
                center = i
                right_boundary = i + P[i]
        print(P)
        return sum((v+1)//2 for v in P)

print(Solution_N().countSubstrings('aaaa'))