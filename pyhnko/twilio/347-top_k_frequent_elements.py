class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        from collections import Counter
        from heapq import heapify, heappop
        
        if not nums: return []
        
        heap = [(-v, k) for k, v in Counter(nums).items()]
        heapify(heap)
        
        return [heappop(heap)[1] for _ in range(k)]
        