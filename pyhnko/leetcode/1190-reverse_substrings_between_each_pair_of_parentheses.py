""" 
class Solution:
    def reverseParentheses(self, s: str) -> str:
        def split(word, start):
            i = start
            cnt = 0
            while i < len(word):
                if word[i] == '(':
                    cnt += 1
                if word[i] == ')':
                    cnt -= 1
                
                if cnt == 0:
                    end = i
                    break
                i += 1
            return word[start+1:end], i
            
        def reverse(word):
            ans = ''
            
            i = 0
            while i < len(word):
                char = word[i]
                if char == '(':
                    aux, i = split(word, i)
                    ans = ans + reverse(aux)[::-1]
                elif char != ')':
                    ans = ans + char
                i += 1
            return ans
        
        return reverse(s)
 """
class Solution:
    def reverseParentheses(self, s: str) -> str:
        from collections import defaultdict
        
        level = 0
        ans = defaultdict(list)
        for char in s:
            if char == '(':
                level += 1
            elif char == ')':
                ans[level-1].extend(ans[level][::-1])
                ans[level] = []
                level -= 1
            else:
                ans[level].append(char)
        
        return ''.join(ans[0])
            