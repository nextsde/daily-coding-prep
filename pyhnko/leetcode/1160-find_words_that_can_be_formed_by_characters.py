class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        from collections import Counter
        
        counter = Counter(chars)
        ans = 0
        for word in words:
            take = True
            for k, v in Counter(word).items():
                if k not in counter or counter[k] < v:
                    take = False
                    break
            
            ans += len(word) if take else 0
    
        return ans