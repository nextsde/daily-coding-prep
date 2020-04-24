class Solution:
    def minSteps(self, s: str, t: str) -> int:
        from collections import Counter
        return sum((v for k, v in (Counter(s)-Counter(t)).items()))