class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        stack = []
        profit = 0
        for price in reversed(prices):
            if stack:
                profit = max(profit, stack[-1] - price)
            
            if not stack or stack[-1] < price:
                stack.append(price)
        
        return profit