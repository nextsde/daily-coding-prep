class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def _subsets(idx, curr, ans):
            if idx == len(nums):
                ans.add(tuple(curr))
                return
            _subsets(idx+1, curr + [nums[idx]], ans)
            _subsets(idx+1, curr, ans)
        
        ans = set()
        _subsets(0, [], ans)
                
        return [list(a) for a in ans] + []
        