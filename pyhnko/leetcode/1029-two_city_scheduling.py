class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        def cost(a, b, idx):
            if a == 0 and b == 0: return 0
            if (a, b) in dp: return dp[(a, b)]
            
            if a == 0:
                total = cost(a, b-1, idx+1) + costs[idx][1]
            elif b == 0:
                total = cost(a-1, b, idx+1) + costs[idx][0]
            else:
                total = min(cost(a-1, b, idx+1) + costs[idx][0], \
                            cost(a, b-1, idx+1) + costs[idx][1])
                
            dp[(a, b)] = total
            
            return total
        
        dp = {}
        n = len(costs)//2
        return cost(n, n, 0)