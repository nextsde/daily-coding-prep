class Solution:
    def numOfArrays(self, N: int, M: int, K: int) -> int:
        
        @lru_cache(None)
        def ways(size, max_element, cost):
            if size == 1:
                return 1 if cost == 1 else 0
    
            ans = ways(size-1, max_element, cost) * max_element
            
            ans += sum(ways(size-1, m, cost-1) for m in range(1, max_element))
            
            return ans % 1000000007
    
        return sum(ways(N, m, K) for m in range(1, M+1)) % 1000000007
        