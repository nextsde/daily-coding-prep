#  First approach
# 
# 
# class Solution:
#     def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
#         from collections import defaultdict
        
#         def get_graph(edges):
#             graph = defaultdict(list)
            
#             for src, dest in edges:
#                 graph[src].append(dest)
#                 graph[dest].append(src)
            
#             return graph
        
#         def bfs(graph, starting_point):
            
#             queue = [starting_point] # node
#             seen = {starting_point,}
            
#             ans = 0
#             while queue:
#                 size = len(queue)
#                 while size:
#                     size -= 1
#                     node = queue.pop(0)
                    
#                     for neighbor in graph[node]:
#                         if neighbor not in seen:
#                             seen.add(neighbor)
#                             queue.append(neighbor)
                    
#                 ans += 1
        
#             return ans
        
#         output = []
#         min_ = float('inf')
#         graph = get_graph(edges)
        
#         for i in range(n):
#             distance = bfs(graph, i)
#             if distance < min_:
#                 output = [i]
#                 min_ = distance
#             elif distance == min_:
#                 output.append(i)
            
#         return output
        
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        from collections import defaultdict
        
        # trim leaves until all nodes have 0 or 1 neighbor
        def get_by_degrees(degrees):
            max_degree = len(max(degrees.values(), key=len))
            
            # all nodes have the same degree - meaning this is the solution
            if all([False for k, v in degrees.items() if len(v) != max_degree]):
                return [k for k, _ in degrees.items()]
            
            # trim leaves
            min_ = len(min(degrees.values(), key=len))
            leaves = [k for k, v in degrees.items() if len(v) == min_]
            for leaf in leaves:
                for neighbor in degrees[leaf]:
                    degrees[neighbor].remove(leaf)
                    degrees[leaf].remove(neighbor)
                    
                    if not degrees[leaf]: del degrees[leaf]
            
            return get_by_degrees(degrees)
        
        if not edges: return [0]
        
        # count degrees
        degrees = defaultdict(list)
        
        for src, dest in edges:
            degrees[src].append(dest)
            degrees[dest].append(src)
            
        return get_by_degrees(degrees)