""" class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ans = [1]
        acc = 1
        for n in nums[:-1]:
            acc *= n
            ans.append(acc)

        acc = 1
        for i in range(len(ans)-2, -1, -1):
            acc *= nums[i+1]
            ans[i]*=acc

        return ans
"""       

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        ans = [1]
        acc = 1
        for n in nums[:-1]:
            acc *= n
            ans.append(acc)
        acc = 1
        i = len(nums)-2
        for n in nums[::-1][:-1]:
            acc *= n
            ans[i] *= acc
            i -= 1
        return ans