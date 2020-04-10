class Solution:
    def reverseStr(self, S: str, k: int) -> str:
        S = list(S)
        for i in range(0, len(S), 2*k):
            S[i:i+k] = S[i:i+k][::-1]
        
        return ''.join(S)