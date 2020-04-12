class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        from heapq import heappop, heappush, heapify
        
        # max heap
        stones = [-n for n in stones]
        heapify(stones)
        
        while len(stones) >= 2:
            x, y = -heappop(stones), -heappop(stones)
            if x != y:
                heappush(stones, y-x)
        
        return -stones[0] if stones else 0
        
        