class Solution:
    def wordSubsets(self, A: List[str], B: List[str]) -> List[str]:
        from collections import Counter
        
        def isValid(a, b):
            a = Counter(a)
            if len(b) > len(a): return False
            for k, v in b.items():
                if k not in b or v > a[k]: return False
                
            return True
        
        b_freq = Counter()
        for b in B:
            b = Counter(b)
            for k, v in b.items():
                if k not in b_freq or v > b_freq[k]: b_freq[k] = v
        
        ans = []
        for a in A:
            if isValid(a, b_freq):
                ans.append(a)
        
        return ans