class Solution:
    def maxVowels(self, S: str, k: int) -> int:
        vowels = 'aeiuo'
        
        l, r = 0, k
        cnt = 0
        for s in S[:k]:
            if s in vowels: cnt += 1
        ans = cnt
        while r < len(S):
            if S[r] in vowels: cnt += 1
            if S[l] in vowels: cnt -= 1
            l += 1
            r += 1
            ans = max(cnt, ans)
        return ans
