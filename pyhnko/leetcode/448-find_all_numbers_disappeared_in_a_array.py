class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        nums = [0] + nums
        
        for i in range(1, len(nums)):
            if nums[abs(nums[i])] > 0: nums[abs(nums[i])]*=-1
        
        ans = []
        for i in range(1, len(nums)):
            if nums[i] >0: ans.append(i)
        
        return ans