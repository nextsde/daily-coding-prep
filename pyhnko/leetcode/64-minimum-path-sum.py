class Solution:
    def minPathSum(self, G: List[List[int]]) -> int:
        R, C = len(G), len(G[0])
        for i in range(R):
            for j in range(C):
                if i == 0 and j == 0: continue
                elif i == 0: G[i][j] += G[i][j-1]
                elif j == 0: G[i][j] += G[i-1][j]
                else: G[i][j] += min(G[i-1][j], G[i][j-1])
        
        return G[-1][-1]