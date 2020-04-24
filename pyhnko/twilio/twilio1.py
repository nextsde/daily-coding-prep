"""
Exercise: Airport Paths - 1

You are given the following unordered list of source and destination airports for a set of routes.
Find the path through the airports and output.

Input:
   SFO → JFK
   PER → SYD
   SYD → SFO
   JFK → LHR

Output:
   PER → SYD → SFO → JFK → LHR

There are no loops or breaks at this stage.


Stage 2: Next introduce a second path.

Input:
   SFO → JFK
   PER → SYD
   SYD → SFO
   JFK → LHR
   HKG → SNG
   SNG → HND

Output:
   PER → SYD → SFO → JFK → LHR
   HKG → SNG → HND
   
Stage 3: Next introduce a loop.

Input:
   SFO → JFK
   PER → SYD
   SYD → SFO
   JFK -> LHR
   JFK → LAX
   LAX → SFO
   HKG → SNG
   SNG → HND

Output:
   PER → SYD → SFO → JFK → LHR
   PER → SYD →SFO →JFK → LAX
   HKG → SNG → HND
"""
from collections import defaultdict

def dfs(v, path):
    visited.add(v)
    if not graph[v]:
        ans.append(path + [v])
    for u in graph[v]:
        if u not in visited:
            dfs(u, path + [v])
        else:
            ans.append(path + [v])


graph = defaultdict(list)

cities = [["SFO","JFK"],["PER", "SYD"], ["SYD", "SFO"], ["JFK", "LHR"], ["JFK", "LAX"], ["LAX", "SFO"], ["HKG", "SNG"], ["SNG", "HND"]]
degree = {}

for src, dest in cities:
    graph[src].append(dest)
    degree[dest] = degree.get(dest, 0) + 1
    if not src in degree:
        degree[src] = 0

starting_points = [ city for city, deg in degree.items() if deg == 0]


ans = []
visited = set()
for start in starting_points:
    dfs(start, [])
print(ans)

