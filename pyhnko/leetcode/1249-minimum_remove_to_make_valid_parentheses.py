class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        aux = ''
        
        for char in s:
            if char.isalpha():
                aux = aux + char
            elif char == '(':
                stack.append(aux)
                aux = ''
            elif char == ')' and stack:
                aux = stack.pop() + f'({aux})'
        
        return ''.join(stack) + aux