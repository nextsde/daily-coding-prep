class Solution:
    def countPrimes(self, n: int) -> int:
        ans = [True]*(n+1)
        
        for i in range(2, int(n**.5)+1):
            for j in range(i+i, n+1, i):
                ans[j] = False
        return sum([1 for a in ans[2:n] if a])
        
#O(N*log(log N))