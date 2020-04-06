class Solution:
    def groupAnagrams(self, W: List[str]) -> List[List[str]]:
        from collections import defaultdict

        group = defaultdict(list)
        for w in W:
            group[''.join(sorted(w))].append(w)

        return group.values()
        
