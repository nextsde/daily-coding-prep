class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r  = 0, len(nums)-1
        
        while l < r:
            mid = (r-l)//2 + l
            if nums[mid] == target: return mid
            elif nums[mid] > target:
                r = mid
            else:
                l = mid+1
        
        if r == len(nums)-1 and nums[r] < target: r += 1
        
        return r