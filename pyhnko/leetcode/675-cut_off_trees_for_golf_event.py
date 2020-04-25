class Solution:
    def cutOffTree(self, F: List[List[int]]) -> int:
        R, C = len(F), len(F[0])
        def get_next(r, c):
            for i, j in (r+1, c), (r-1, c), (r, c+1), (r, c-1):
                if 0<=i<R and 0<=j<C and (i, j) not in visited and F[i][j] != 0:
                    yield i, j
        
        to_cut = sorted(((F[i][j], i, j) for i in range(R) for j in range(C) if F[i][j] > 1))
        n_cut = len(to_cut)
        removed = 0
        
        r, c = 0, 0
        ans = 0
        while to_cut:
            _, I, J = to_cut.pop(0)
            queue = [(r, c, 0)]
            visited = {(r, c),}
            
            while queue:
                r, c, d = queue.pop(0)
                if r == I and c == J:
                    removed += 1
                    ans += d
                    break
                for ii, jj in get_next(r, c):
                    visited.add((ii, jj))
                    queue.append((ii, jj, d+1))
        
        return ans if n_cut == removed else -1