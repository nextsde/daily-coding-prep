class Solution:
    def divisorGame(self, N: int) -> bool:
        def div(n):
            for i in range(1, n):
                if n%i == 0:
                    yield i
        
        def game(n):
            if n == 2: return 1
            
            if n in dp: return dp[n]
            
            ans = 0
            for i in div(n):
                ans = max(ans, not game(n-i))
            
            dp[n] = ans
            return dp[n]
    
        dp = {}
        return True if game(N) else False

# better solution 
# return True if  N%2==0 else False