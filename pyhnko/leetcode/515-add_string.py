class Solution:
    def addStrings(self, A: str, B: str) -> str:
        ans = ''
        i, j, carry = len(A)-1, len(B)-1, 0

        while i >= 0 or j >= 0 or carry:
            a = ord(A[i]) - ord('0') if i>=0 else 0
            b = ord(B[j]) - ord('0') if j>= 0 else 0
            n = a+b+carry
            ans = chr(ord('0') + (n)%10) + ans
            i, j, carry = i-1, j-1, n//10

        return ans
