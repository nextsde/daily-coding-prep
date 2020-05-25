class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        def solve(curr):
            ans.add(curr)
            for i, val in enumerate(take):
                if val: continue
                take[i] = True
                solve(curr + tiles[i])
                take[i] = False
        
        take = [False]*len(tiles)
        ans = set()
        solve('')
        return len(ans)-1