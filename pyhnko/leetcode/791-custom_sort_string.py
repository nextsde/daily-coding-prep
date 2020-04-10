class Solution:
    def customSortString(self, S: str, T: str) -> str:
        from collections import Counter
        freq = Counter(list(T))
        not_in = ''
        for t in T:
            if t not in S:
                not_in = not_in + t
        
        yes_in = ''
        for s in S:
            if s in T:
                yes_in = yes_in + s*freq[s]
        return yes_in + not_in