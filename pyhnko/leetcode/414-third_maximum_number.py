class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        f = s = t = -float('inf')
        for n in nums:
            if n > f:
                f, s, t = n, f, s
            elif n<f and n>s:
                s, t = n, s
            elif n<f and n<s and n>t:
                t = n

        if t == -float('inf'):
            return f
        return t
