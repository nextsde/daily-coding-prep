class Solution:
    def isValid(self, s: str) -> bool:
        parenthesis = {'(': ')', '{':'}', '[':']'}
        stack = []
        
        for char in s:
            if char in '([{':
                stack.append(char)
            elif not stack or parenthesis[stack.pop()] != char: return False
        
        return not stack
                
