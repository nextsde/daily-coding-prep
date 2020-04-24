class Solution:
    def largestRectangleArea(self, H: List[int]) -> int:
        total = 0
        stack = []
        for i, val in enumerate(H):
            while stack and H[stack[-1]]> val:
                top = stack.pop()
                if stack:
                    area = H[top]*(i-stack[-1]-1)
                else:
                    area = H[top] * i
                total = max(total, area)
            stack.append(i)
        
        i = len(H)
        while stack:
            top = stack.pop()
            if stack:
                area = H[top]*(i-stack[-1]-1)
            else:
                area = H[top] * i
            total = max(total, area)
        return total