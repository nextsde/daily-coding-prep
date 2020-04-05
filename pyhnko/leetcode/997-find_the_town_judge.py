class Solution:
    def findJudge(self, N: int, T: List[List[int]]) -> int:
        from collections import defaultdict

        in_ = defaultdict(int)
        out = defaultdict(int)

        for src, dest in T:
            in_[dest] += 1
            out[src]  += 1

        for i in range(1, N+1):
            if in_[i] == N-1 and out[i] == 0: return i

        return -1
