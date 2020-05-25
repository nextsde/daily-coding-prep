""" class Solution:
    def wordBreak(self, S: str, wordDict: List[str]) -> bool:
        def find(left):
            if left == len(S): return True
            if left in dp: return dp[left]
            
            ans = False
            for right in range(left, len(S), 1):
                if S[left:right+1] in words and find(right+1):
                    ans = True
                    break
            
            dp[left] = ans
            return ans
        dp = {}
        words = set(wordDict)
        return find(0)
 """
class Solution:
    def wordBreak(self, S: str, wordDict: List[str]) -> bool:
        dp = [False]* (len(S)+1)
        dp[0] = True
        
        words = set(wordDict)
        for i in range(len(S)):
            for j in range(i, len(S)):
                if S[i:j+1] in words and dp[i]:
                    dp[j+1] = True
        
        return dp[-1]