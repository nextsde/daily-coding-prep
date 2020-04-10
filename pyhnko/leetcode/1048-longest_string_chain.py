class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        # d = {}
        # for w in sorted(words, key=len):
        #     d[w] = max(d.get(w[:i] + w[i+1:], 0)+1 for i in range(len(w)))
        # return max(d.values())
        
        def dfs(w):
            if w not in valid: return 0
            if w in dp: return dp[w]
            
            dp[w] = max(dfs(w[:i] + w[i+1:])+1 for i in range(len(w)))
            return dp[w]
        dp = {}
        valid = {w for w in words}
        return max(dfs(w) for w in words if w not in dp)