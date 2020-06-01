class Solution:
    def findAnagrams(self, S: str, P: str) -> List[int]:
        def check(A, B):
            return all(a == b for a, b in zip(A, B))
        
        if not S or len(S) < len(P): return []
        
        p = [0]*26
        for char in P:
            p[ord(char)-ord('a')] += 1
    
        anagram = [0]*26
        len_p = len(P)
        
        for char in S[:len_p]: anagram[ord(char)-ord('a')] += 1
        
        ans = []
        if check(p, anagram):
            ans.append(0)
        
        l, r = 0, len_p
        while r < len(S):
            anagram[ord(S[l])-ord('a')] -= 1
            anagram[ord(S[r])-ord('a')] += 1
            l+=1; r+=1
            
            if check(p, anagram):
                ans.append(l)
        
        return ans