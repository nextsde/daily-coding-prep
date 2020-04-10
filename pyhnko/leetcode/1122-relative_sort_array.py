class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        from collections import defaultdict
        
        freq = defaultdict(int)
        for n in arr1: freq[n] += 1
        
        ans = []
        for n in arr2:
            ans.extend([n]*freq[n])
        
        not_included = sorted([n for n in arr1 if n not in arr2])
        
        return ans + not_included