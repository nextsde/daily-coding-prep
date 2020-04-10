""" class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        return sorted([n*n for n in A])
 """
class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        # get the index of the last negative number
        idx = -1
        for i in range(len(A)):
            if A[i] < 0: idx = i
        
        for i in range(len(A)):
            A[i] *= A[i]
        
        if idx != -1:
            L, R = A[:idx+1], A[idx+1:]
        else:
            L, R = [], A
        
        l, r = len(L)-1, 0
        ans = []
        while l >= 0 or r < len(R):
            a = L[l] if l >=0 else float('inf')
            b = R[r] if r<len(R) else float('inf')
            
            if a < b:
                l -= 1
            else:
                r += 1
            
            ans.append(min(a, b))

        
        return ans


