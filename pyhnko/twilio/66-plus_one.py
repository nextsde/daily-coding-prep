class Solution:
    def plusOne(self, A: List[int]) -> List[int]:
        
        carry = 1
        i = len(A)-1
        while i>=0 or carry:
            n = A[i] if i >= 0 else 0
            
            if i >= 0:
                A[i] = (n+carry)%10
            else:
                A = [1] + A
            carry = (n+carry)//10
            i -= 1
        
        return A
    
