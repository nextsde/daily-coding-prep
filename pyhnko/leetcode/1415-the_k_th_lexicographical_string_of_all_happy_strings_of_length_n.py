class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        from collections import deque
        
        mp = {'a':'bc', 'b':'ac', 'c':'ab'}
        
        queue = deque(['a', 'b', 'c'])
        while len(queue[0]) < n:
            v = queue.popleft()
            for u in mp[v[-1]]:
                queue.append(v+u)
        
        return queue[k-1] if k <= len(queue) else ''