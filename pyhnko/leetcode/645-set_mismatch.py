class Solution:
    def findErrorNums(self, A: List[int]) -> List[int]:

        for val in A:
            if A[abs(val)-1] > 0:
                A[abs(val)-1] *= -1
            else:
                rep = abs(val)
        
        for i, val in enumerate(A):
            if val > 0 :
                return rep, i+1
            