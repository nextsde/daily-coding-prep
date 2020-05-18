class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        i = j = 0
        
        ans = []
        while i<len(A) and j<len(B):
            la, ra, lb, rb = *A[i], *B[j]
            
            if lb <= ra or rb >= la:
                
                nl, nr = max(la, lb), min(ra, rb)
                if nl <= nr:
                    ans.append([nl, nr])
                
            if ra < rb: i += 1
            else:       j += 1
        
        return ans