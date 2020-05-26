class NumMatrix:
    
    def __init__(self, M: List[List[int]]):
        if not M: return
        R, C = len(M)+1, len(M[0])+1
        self.dp = [[0 for j in range(C)] for i in range(R)]
        
        for i in range(1, R):
            for j in range(1, C):
                self.dp[i][j] = self.dp[i][j-1] + self.dp[i-1][j] - self.dp[i-1][j-1] + M[i-1][j-1]

    def sumRegion(self, r1: int, c1: int, r2: int, c2: int) -> int:
        r1+=1;r2+=1
        c1+=1;c2+=1
        return self.dp[r2][c2] - self.dp[r2][c1-1] - self.dp[r1-1][c2] + self.dp[r1-1][c1-1]
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)

"""

"""
