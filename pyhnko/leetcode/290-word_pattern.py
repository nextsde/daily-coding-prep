class Solution:
    def wordPattern(self, pattern: str, string: str) -> bool:
        patterns, words = list(pattern), string.split()
        if len(patterns) != len(words): return False
        
        letter = {}
        word = {}
        
        for l, w in zip(patterns, words):
            if l not in word and w not in letter:
                letter[w] = l
                word[l] = w
            elif l in word and w in letter and word[l] == w and letter[w] == l: continue
            else: return False
        
        return True