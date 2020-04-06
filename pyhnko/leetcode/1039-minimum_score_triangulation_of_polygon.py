class Solution:
    def minScoreTriangulation(self, A: List[int]) -> int:
        def get_min(left, right):
            if right - left + 1 < 3: return 0
            if (left, right) in dp: return dp[(left, right)]

            min_ = float('inf')
            for k in range(left+1, right):
                cost = get_min(left, k) + A[left]*A[k]*A[right] + get_min(k, right)
                min_ = min(min_, cost)

            dp[(left, right)] = min_
            return min_
        dp = {}
        return get_min(0, len(A)-1)

   # check https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/294265/Python-In-depth-Explanation-DP-For-Beginners
