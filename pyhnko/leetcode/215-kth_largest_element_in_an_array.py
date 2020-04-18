class Solution:
    def findKthLargest(self, A: List[int], k: int) -> int:
        def partition(lo, hi):
            pivot = A[hi]
            i = lo
            for j in range(lo, hi):
                if A[j] < pivot:
                    A[i], A[j] = A[j], A[i]
                    i += 1
            A[i], A[hi] = A[hi], A[i]
            return i
        
        l, r = 0, len(A)-1
        while True:
            idx = partition(l, r)
            if len(A)-k == idx: return A[idx]
            elif len(A)-k > idx: l = idx+1
            else: r = idx-1
        
        return -1