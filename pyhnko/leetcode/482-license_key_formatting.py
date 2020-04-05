class Solution:
    def licenseKeyFormatting(self, S: str, k: int) -> str:
        ans = ''
        i = len(S)-1
        cnt = 0

        while i >= 0:
            if S[i] != '-':
                ans = S[i] + ans
                cnt += 1
            i -= 1
            if cnt == k:
                ans = '-' + ans
                cnt = 0
        if ans and ans[0] == '-':
            ans = ans[1:]
        return ans.upper()
