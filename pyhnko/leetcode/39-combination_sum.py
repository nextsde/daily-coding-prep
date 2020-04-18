class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def combine(curr, sum, idx):
            if sum == target:
                ans.append(curr[:])
            elif sum < target:
                for i in range(idx, L):
                    combine(curr + [candidates[i]], sum + candidates[i], i)
            
        ans = []
        L = len(candidates)
        combine([], 0, 0)
        return ans