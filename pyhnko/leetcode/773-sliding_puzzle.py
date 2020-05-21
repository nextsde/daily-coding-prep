class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        from collections import deque
        
        R, C = 2, 3
        def to_string(B):
            return '#'.join(''.join(map(str, b)) for b in B)
        
        def to_matrix(B):
            return [[int(n) for n in b] for b in B.split('#')]
        
        def next_move(B):
            B = to_matrix(B)
            for i in range(R):
                for j in range(C):
                    if B[i][j] == 0:
                        r, c = i, j
                        break
            
            for i, j in (r+1, c), (r-1, c), (r, c+1), (r, c-1):
                if 0<=i<R and 0<=j<C:
                    B[i][j], B[r][c] = B[r][c], B[i][j]
                    aux = to_string(B)
                    if aux not in visited:
                        visited.add(aux)
                        yield aux
                    
                    B[i][j], B[r][c] = B[r][c], B[i][j]
        
        target = to_string([[1,2,3],[4,5,0]])
        start = to_string(board)
        visited = {start,}
        queue = deque([(start, 0)])
        
        while queue:
            node, d = queue.popleft()
            if node == target: return d
            
            for next in next_move(node):
                queue.append((next, d+1))
        
        return -1
        