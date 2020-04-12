class Solution:
    def sortColors(self, A: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r, i = 0, len(A)-1, 0
        
        while i <= r:
            if A[i] == 2:
                A[i], A[r] = A[r], A[i]
                r -= 1
            elif A[i] == 0:
                A[i], A[l] = A[l], A[i]
                l += 1
                i += 1
            else:
                i += 1
        