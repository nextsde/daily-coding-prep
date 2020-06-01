class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        R, C, MOD = len(pizza), len(pizza[0]), 10 ** 9 + 7
        P = [[0]*(C+1) for _ in range(R+1)]
        for i in range(R-1, -1, -1):
            for j in range(C-1, -1, -1):
                P[i][j] = P[i][j+1] + P[i+1][j] - P[i+1][j+1] + (pizza[i][j] == 'A')*1
        
        def solve(r, c, k):
            if P[r][c] == 0: return 0
            if k == 0: return 1
            if (r, c, k) in dp: return dp[(r, c, k)]
            
            ans = 0
            
            # vertical
            for nc in range(c+1, C):
                if P[r][c] - P[r][nc] > 0:
                    ans = (ans + solve(r, nc, k-1)) % MOD
            
            # horizontal
            for nr in range(r+1, R):
                if P[r][c] - P[nr][c] > 0:
                    ans = (ans + solve(nr, c, k-1)) % MOD
            
            dp[(r, c, k)] = ans
            return ans
        
        dp = {}
        return solve(0, 0, k-1)
