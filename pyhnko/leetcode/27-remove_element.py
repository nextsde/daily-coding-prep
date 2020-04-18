class Solution:
    def removeElement(self, A: List[int], val: int) -> int:
        l, r = 0, len(A)-1
        
        while l <= r:
            if A[l] == val:
                A[l], A[r] = A[r], A[l]
                r -= 1
            else:
                l += 1
        
        return l