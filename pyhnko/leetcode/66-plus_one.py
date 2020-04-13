class Solution:
    def plusOne(self, A: List[int]) -> List[int]:
        carry = 1 
        i = len(A)-1
        
        while i >= 0 or carry:
            d = A[i] if i >=0 else 0
            
            n = d+carry
            carry = n // 10
            
            if i >=0:
                A[i] = n%10
            else: 
                A = [n] + A
            
            i-=1
        
        return A
                