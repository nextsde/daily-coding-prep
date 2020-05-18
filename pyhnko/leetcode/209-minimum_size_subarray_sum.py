class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
            
        l = r = cnt = 0
        ans = float('inf')
        while r < len(nums) or cnt >= target:
            if cnt >= target: 
                ans = min(ans, r-l)
            
            if cnt >=target:
                cnt -= nums[l]
                l += 1
            else:
                cnt += nums[r]
                r += 1
        
        return ans if ans != float('inf') else 0
                