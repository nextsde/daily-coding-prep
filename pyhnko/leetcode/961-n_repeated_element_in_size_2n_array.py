class Solution:
    def repeatedNTimes(self, A: List[int]) -> int:
        
        for j in range(1, 4):
            for i in range(0, len(A)-j):
                if A[i] == A[i+j]: return A[i]
        
        return -1