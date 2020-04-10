class Solution:
    def criticalConnections(self, N: int, connections: List[List[int]]) -> List[List[int]]:
        from collections import defaultdict
        
        def get_graph(connections):
            graph = defaultdict(list)
            for src, dest in connections:
                graph[src].append(dest)
                graph[dest].append(src)
            return graph
        
        def dfs_bridges(at, parent, bridges):
            visited.add(at)
            self.id_ += 1
            low[at] = ids[at] = self.id_
            
            for to in graph[at]:
                if to == parent: continue
                if to not in visited:
                    dfs_bridges(to, at, bridges)
                    low[at] = min(low[at], low[to])
                    if ids[at] < low[to]:
                        bridges.append([at, to])
                else:
                    low[at] = min(low[at], ids[to])
        
        graph = get_graph(connections)
        ids, low = [0]*N, [0]*N
        visited = set()
        self.id_ = 0
        bridges = []
        for i in range(0, N):
            if i not in visited:
                dfs_bridges(i, -1, bridges)
                
        return bridges


# check the tutorial: https://www.youtube.com/watch?v=aZXi1unBdJA