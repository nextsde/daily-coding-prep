class Solution:
    def kthGrammar(self, N: int, k: int) -> int:

        s = 2**N
        flip = 0
        while s > 2:
            if k > s//2:
                k -= s//2
                flip +=1
            s //= 2

        k -= 1

        return 1-k if flip%2==1 else k


# https://www.youtube.com/watch?v=tuMWyDsIpEQ
