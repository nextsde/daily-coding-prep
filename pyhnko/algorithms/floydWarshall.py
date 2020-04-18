def path(i, j):
    if nxt[i][j] == None: return []
    ans = [i]
    while i != j:
        i = nxt[i][j]
        ans.append(i)
    return ans

dp = [[float('inf') for c in range(n)] for r in range(n)]
nxt = [[None for c in range(n)] for r in range(n)]

for i in range(n): 
    dp[i][i] = 0
    nxt[i][i] = i
    
for src, dest, w in edges:
    dp[src][dest] = dp[dest][src] = w
    nxt[src][dest] = dest
    nxt[dest][src] = src
    

for k in range(n):
    for i in range(n):
        for j in range(n):
            if dp[i][k] + dp[k][j] < dp[i][j]:
                dp[i][j] = dp[i][k] + dp[k][j]
                nxt[i][j] = k

# when to use: for finding shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles)
# tutorial: https://www.youtube.com/watch?v=oNI0rf2P9gE
# leetcode problem: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/