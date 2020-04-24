class Solution:
    def gardenNoAdj(self, N: int, paths: List[List[int]]) -> List[int]:
        from collections import defaultdict
        
        def dfs(v):
            cur_id = 0
            for i in range(1, N+1):
                if i not in id[v]:
                    cur_id = i
                    break
            ans[v] = cur_id
            for u in graph[v]:
                id[u].add(cur_id)
            
            seen.add(v)
            for u in graph[v]:
                if u not in seen:
                    dfs(u)
            
        graph = defaultdict(list)
        for src, dest in paths:
            graph[src].append(dest)
            graph[dest].append(src)
        
        seen = set()
        ans = [-1]*(N+1)
        id = defaultdict(set)
        
        for i in range(1, N+1):
            if i not in seen:
                dfs(i)
            
        return ans[1:]