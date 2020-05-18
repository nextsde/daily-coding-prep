class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        from collections import Counter
        m = Counter(magazine)
        
        for k, v in Counter(ransomNote).items():
            if k not in m or m[k]<v: return False
        
        return True
        