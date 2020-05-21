class Solution:
    def reverseVowels(self, s: str) -> str:
        l, r = 0, len(s)-1
        vowel = set('aeiou')
        s = list(s)
        
        while l < r:
            while l < len(s) and s[l].lower() not in vowel: l+=1
            while r >= 0 and s[r].lower() not in vowel: r-=1
            
            if l < r:
                s[l], s[r] = s[r], s[l]
                l += 1
                r -= 1
        
        return ''.join(s)