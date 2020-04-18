class Solution:
    def countServers(self, G: List[List[int]]) -> int:
        R, C = len(G), len(G[0])
        rows, cols = [0]*R, [0]*C
        pnts = []
        for i in range(R):
            for j in range(C):
                if G[i][j]:
                    pnts.append((i, j))
                    rows[i] += 1
                    cols[j] += 1
        
        ans = 0
        for r, c in pnts:
            if rows[r] > 1 or cols[c] > 1: ans += 1
        
        return ans

