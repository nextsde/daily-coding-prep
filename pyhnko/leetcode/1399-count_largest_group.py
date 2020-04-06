class Solution:
    def countLargestGroup(self, n: int) -> int:
        from collections import defaultdict

        def get_sum(N):
            ans = 0
            while N:
                ans += N%10
                N //= 10
            return ans

        groups = defaultdict(int)
        for i in range(1, n+1):
            groups[get_sum(i)] += 1

        max_ = max(groups.values())
        cnt = 0
        for k, v in groups.items():
            if v == max_: cnt += 1

        return cnt
        
