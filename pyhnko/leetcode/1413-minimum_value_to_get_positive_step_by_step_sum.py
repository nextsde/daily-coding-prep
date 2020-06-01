class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        start = 0
        curr = 0
        for n in nums:
            curr += n
            if curr < 1:
                start += abs(curr-1)
                curr = 1
        
        return start if start else 1