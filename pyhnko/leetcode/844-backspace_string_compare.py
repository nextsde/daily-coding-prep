class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        def clean(string):
            ans = ''
            cnt = 0
            for s in string[::-1]:
                if s == '#':
                    cnt += 1
                else:
                    if cnt == 0: ans = s + ans
                    else: cnt -= 1
            
            return ans
        
        return clean(S) == clean(T)