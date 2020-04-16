class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        from collections import defaultdict
        from heapq import heappop, heappush
        
        graph = defaultdict(list)
        for s, d, w in flights:
            graph[s].append((d, w))
        
        visited = set()
        pq = [(0, src, -1)]
        
        while pq:
            c, v, k =  heappop(pq)
            if v == dst and k <= K: return c
            if k < K:
                visited.add(v)
            elif k > K: continue
            for u, u_c in graph[v]:
                if u not in visited:
                    heappush(pq, (c+u_c, u, k+1))
        
        return -1
        
            