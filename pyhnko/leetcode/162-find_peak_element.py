""" O(N)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        nums = [-float('inf')] + nums + [-float('inf')]
        
        for i, n in enumerate(nums[1:-1], 1):
            if nums[i-1] < n > nums[i+1]: return i-1
        
        return -1 
"""

class Solution(object):
    def findPeakElement(self, A):
        """
        :type nums: List[int]
        :rtype: int
        """
        #[1,2,3,1]
        #[1,2,1,3,5,6,4]
        l, r = 0, len(A)-1
        
        while l < r:
            mid = (r-l)//2 + l
            if A[mid] < A[mid+1]:
                l = mid + 1
            else:
                r = mid
        return l