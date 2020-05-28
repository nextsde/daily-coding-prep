class Solution:
    def reformat(self, S: str) -> str:
        digits = []
        letters = []
        
        for s in S:
            if s.isdigit(): digits.append(s)
            else: letters.append(s)
        
        len_d, len_l = len(digits), len(letters)
        if abs(len_d - len_l) > 1: return ""
        
        ans = []
        if len_d > len_l:
            A, B = digits, letters
            
        else:
            A, B = letters, digits
        
        for a, b in zip(A, B):
            ans.append(a)
            ans.append(b)
        
        if len_d != len_l:
            ans.append(A[-1])
        
        return ''.join(ans)