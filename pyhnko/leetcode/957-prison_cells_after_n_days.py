class Solution:
    def prisonAfterNDays(self, cells: List[int], N: int) -> List[int]:
        def next_day(cells):
            return [int(i>0 and i<7 and cells[i-1] == cells[i+1])
                    for i in range(8)]
    
        seen = set()
        patron = False
        size = 0
        for _ in range(N):
            next = next_day(cells)
            c = tuple(next)
            if c in seen:
                patron = True
                break
            seen.add(c)
            cells = next
            size += 1
        
        if patron:
            N = N%size
        
            for _ in range(1, N+1):
                cells = next_day(cells)
        
        return cells
            