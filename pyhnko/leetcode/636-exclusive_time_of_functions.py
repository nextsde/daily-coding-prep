class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        total = [0 for _ in range(n)]
        current_time = 0
        
        for log in logs:
            log = log.split(':')
            id, mode, next_time = int(log[0]), log[1], int(log[2])
            
            if mode == 'start':
                if stack:
                    total[stack[-1]] += next_time - current_time
                stack.append(id)
                current_time = next_time
            else:
                total[stack[-1]] += next_time - current_time + 1
                stack.pop()
                current_time = next_time + 1
        
        return total