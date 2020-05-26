class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        from collections import deque, defaultdict
        
        def dfs(v):
            seen.add(v)
            if not graph[v]:
                return 0 if v not in apples else 2
                        
            ans = 0
            for u in graph[v]:
                if u not in seen:
                    ans += dfs(u)   
            if ans:
                return 2 + ans
            return 2 if v in apples else 0
                
        
        
        apples = {i for i, val in enumerate(hasApple) if val}
        
        graph = defaultdict(list)
        for src, dest in edges:
            graph[src].append(dest)
            graph[dest].append(src)
        
        seen = set()
        ans = dfs(0)
        return ans-2 if ans else 0