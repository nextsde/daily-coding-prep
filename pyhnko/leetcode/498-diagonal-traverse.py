class Solution:
    def findDiagonalOrder(self, M: List[List[int]]) -> List[int]:
        if not M: return []
        
        ans = []
        rev = 0
        i, j = 0, 0
        L = len(M) + len(M[0]) - 1
        while L:
            L -= 1
            diagonal = []
            r, c = i, j
            while r < len(M) and c >= 0:
                diagonal.append(M[r][c])
                r += 1
                c -= 1
            if j == len(M[0])-1:
                i += 1
            else:
                j += 1
            diagonal = diagonal if rev else diagonal[::-1]
            rev = 1 - rev
            ans.extend(diagonal)
        
        return ans