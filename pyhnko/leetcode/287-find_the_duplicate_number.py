class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        hare = tortoise = nums[0]

        while True:
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]

            if hare == tortoise: break

        ans = nums[0]
        while ans != tortoise:
            ans = nums[ans]
            tortoise = nums[tortoise]

        return ans
