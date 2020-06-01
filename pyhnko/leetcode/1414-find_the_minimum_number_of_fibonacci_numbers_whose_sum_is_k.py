class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        if k < 2: return k
        a, b = 1, 1
        while b <= k:
            a, b = b, a+b
        
        return 1 + self.findMinFibonacciNumbers(k-a)
            
