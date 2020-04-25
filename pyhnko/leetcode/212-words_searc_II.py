class Trie:
    def __init__(self):
        self.trie = {}
        
    def insert(self, word):
        trie = self.trie
        for w in word:
            if w not in trie:
                trie[w] = {}
            trie = trie[w]
        
        trie['*'] = word
    
    def insert_all(self, words):
        for word in words:
            self.insert(word)
    
class Solution:
    def findWords(self, B: List[List[str]], words: List[str]) -> List[str]:
        from collections import defaultdict

        def neighbors(r, c):
            for i, j in (r+1, c), (r-1, c), (r, c-1), (r, c+1):
                if 0<=i<R and 0<=j<C and B[i][j] != ' ':
                    yield i, j
                    
        def dfs(curr, r, c, output):
            if '*' in curr:
                output.append(curr['*'])
                del curr['*']
            char = B[r][c]
            B[r][c] = ' '
            for i, j in neighbors(r, c):
                if B[i][j] in curr:
                    dfs(curr[B[i][j]], i, j, output)
            B[r][c] = char
            
            
        R, C = len(B), len(B[0])
        t = Trie()
        t.insert_all(words)
        output = []
        
        for i in range(R):
            for j in range(C):
                char = B[i][j]
                if char in t.trie:
                    dfs(t.trie[char], i, j, output)
        
        return output