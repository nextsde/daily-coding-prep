class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        i = 0
        cnt = 0
        while i < len(nums):
            if nums[i] == 1:
                if i>0 and cnt < k: return False
                cnt = 0
            else:
                cnt += 1
            i+=1
        
        return True
"""            
class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        
        start = 1 if nums[0] else 0
        cnt = (nums[0] == 0)*1
        for val in nums[start:]:
            if val == 0:
                cnt += 1
            if val == 1:
                if cnt < k: return False
                cnt = 0
        
        return True
"""