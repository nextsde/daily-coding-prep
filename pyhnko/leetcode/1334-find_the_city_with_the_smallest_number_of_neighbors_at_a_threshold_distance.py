class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        dp = [[float('inf') for c in range(n)] for r in range(n)]
        for i in range(n): dp[i][i] = 0
            
        for src, dest, w in edges:
            dp[src][dest] = dp[dest][src] = w
        
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
        
        min_cities = n
        id_ = n
        for i in range(n):
            n_cities = -1
            for j in range(n):
                if dp[i][j] <= distanceThreshold: n_cities += 1
            
            if min_cities >= n_cities:
                min_cities = n_cities
                id_ = i
        
        return id_
            