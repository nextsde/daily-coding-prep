class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        from collections import defaultdict, deque
        
        graph = defaultdict(list)
        degree = [0]*numCourses
        
        for dest, src in prerequisites:
            graph[src].append(dest)
            degree[dest] += 1
        
        queue = deque([i for i, n in enumerate(degree) if not n])
        ans = []
        cnt = 0
        while queue:
            v = queue.popleft()
            for u in graph[v]:
                degree[u] -= 1
                if not degree[u]:
                    queue.append(u)
            ans.append(v)
            cnt += 1
            
        return ans if cnt == numCourses else []
            
        