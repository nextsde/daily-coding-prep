class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        for i, row in enumerate(A):
            for j, n in enumerate(row[::-1]):
                A[i][j] = 1-n
        
        return A