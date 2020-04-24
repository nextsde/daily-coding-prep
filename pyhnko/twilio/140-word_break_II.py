class Solution:
    def wordBreak(self, S: str, wordDict: List[str]) -> List[str]:
        def backtrack(pos, curr, ans):
            if pos == -1:
                ans.append(curr.strip())
            else:
                for i in solutions[pos]:
                    backtrack(i, S[i:pos] + ' ' + curr, ans)
                
            
            
        dp = [False]*(len(S) + 1)
        dp[0] = True
        W = set(wordDict)
        solutions = [[] for i in range(len(S)+1)]
        solutions[0] = [-1]
        for i in range(len(S)):
            for j in range(i, len(S)):
                if S[i:j+1] in W and dp[i]:
                    dp[j+1] = True
                    solutions[j+1].append(i)
        # print(solutions)
        if not dp[-1]: return []
        ans = []
        backtrack(len(S), '', ans)
        return ans