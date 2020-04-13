class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        M = [[0 for _ in range(n) ] for __ in range(n)]
        
        cnt = 1
        i, j = 0, 0
        turn = 0
        pointer = 1
        limits = {'right': n, 'down': n, 'left': -1, 'up': 1}
        
        
        while pointer <= n*n:
            
            # right
            if turn == 0:
                while j < limits['right']:
                    M[i][j] = pointer
                    pointer += 1
                    j+=1
                j -= 1
                i += 1
                limits['right'] -= 1
            
            # down
            elif turn == 1:
                while i < limits['down']:
                    M[i][j] = pointer
                    pointer += 1
                    i += 1
                i -= 1
                j -= 1
                limits['down'] -= 1
            
            # left
            elif turn == 2:
                while j > limits['left']:
                    print(i, j, pointer)
                    M[i][j] = pointer
                    pointer += 1
                    j -= 1
                j += 1
                i -= 1
                limits['left'] += 1
                
            # up
            else:
                while i >= limits['up']:
                    M[i][j] = pointer
                    pointer += 1
                    i -= 1
                i += 1
                j += 1
                limits['up'] += 1  
                
            turn = (turn +1)%4
            print(M)
        return M