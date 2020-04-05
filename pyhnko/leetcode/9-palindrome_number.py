class Solution:
    def isPalindrome(self, x: int) -> bool:
        def reverse(N):
            ans = 0
            while N:
                ans = ans * 10 + N%10
                N  //= 10

            return ans

        return reverse(x) == x if x >=0 else False
