class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        
        def neighbors(r, c):
            for i, j in (r-1, c), (r, c-1), (r, c+1), (r+1, c):
                if 0<=i<R and 0<=j<C and (i, j) not in seen and grid[i][j] == 1:
                    yield i, j
        

        queue = []
        seen = set()
        rotten = 0
        fresh = 0
        for i in range(R):
            for j in range(C):
                if grid[i][j] == 2:
                    queue.append((i, j))
                    seen.add((i, j))
                    rotten += 1
                elif grid[i][j] == 1:
                    fresh += 1
    
        
        if not rotten and not fresh : return 0
        if not rotten: return -1
        ans = 0
        while queue:
            size = len(queue)
            while size:
                size -= 1
                i, j = queue.pop(0)
                
                for ii, jj in neighbors(i, j):
                    queue.append((ii, jj))
                    seen.add((ii, jj))
            ans += 1
        return ans-1 if len(seen) == fresh+rotten else -1