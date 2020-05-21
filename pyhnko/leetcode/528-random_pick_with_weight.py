# My first approach was linear. Better logarithmic
class Solution:

    def __init__(self, weight: List[int]):
        total = sum(weight)
        self.W = [weight[0]/total]
        for w in weight[1:]:
            self.W.append(self.W[-1] + w/total)

    def pickIndex(self) -> int:
        from random import random
        seed = random()
        
        l, r = 0, len(self.W)-1
        while l < r:
            mid = (r-l)//2 + l
            if self.W[mid] >= seed: r = mid
            else: l = mid+1
        
        return l
            

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()