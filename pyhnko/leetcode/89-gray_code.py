class Solution:
    def grayCode(self, n: int) -> List[int]:
        ans = [0]
        for i in range(1, 2**n):
            ans.append(ans[-1] ^ (i&-i))
        
        return ans

