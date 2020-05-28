class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        ans = set()
        for i in range(len(words)):
            for j in range(len(words)):
                if i==j: continue
                if words[j] in words[i]:
                    ans.add(words[j])
        
        return list(ans)