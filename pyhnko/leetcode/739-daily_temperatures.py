class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        ans = [0]*len(T)
        stack = []
        loc = {}
        
        i = len(T)-1
        while i >= 0:
            val = T[i]
            while stack and stack[-1][0] <= val:
                stack.pop()
            ans[i] = 0 if not stack else stack[-1][1] - i
            
            stack.append((val, i))
            i -= 1
        
        return ans        
