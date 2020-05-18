class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        from collections import Counter
        from heapq import heapify, heappop, heappush
        
        heap = [(-v, k) for k, v in Counter(barcodes).items()]
        heapify(heap)
        
        ans = []
        while heap:
            v1, k1 = heappop(heap)
            ans.append(k1)
            if heap:
                v2, k2 = heappop(heap)
                ans.append(k2)
                if v2+1 != 0:
                    heappush(heap, (v2+1, k2))
            if v1+1 != 0:
                heappush(heap, (v1+1, k1))
        
        return ans