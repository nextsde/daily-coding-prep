class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        d = {0:-1}
        count = 0
        ans = 0
        for i, n in enumerate(nums):
            count += 1 if n else -1
            if count in d:
                ans = max(ans, i - d[count]) 
            else:
                d[count] = i
        
        return ans
