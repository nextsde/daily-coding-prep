class Solution:
    def minNumberOfFrogs(self, C: str) -> int:
        
        idx = dict(zip('croak', range(5)))
        
        freq = [0]*5
        total = 0
        for c in C:
            freq[idx[c]] += 1
            if freq[idx[c]] > freq[idx['c']]: return -1
            
            total = max(total, freq[idx['c']] - freq[idx['k']])
    
        for a, b in zip(freq, freq[1:]):
            if a != b: return -1
        return total