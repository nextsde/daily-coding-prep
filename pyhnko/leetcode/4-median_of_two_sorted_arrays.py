class Solution:
    def findMedianSortedArrays(self, A: List[int], B: List[int]) -> float:
        if len(A) > len(B):
            return self.findMedianSortedArrays(B, A)
        
        x, y = len(A), len(B)
        lo, hi = 0, x
        
        while lo <= hi:
            partX = (hi - lo)//2 + lo
            partY = (x+y+1)//2 - partX
            
            maxLeftX = -float('inf') if partX == 0 else A[partX-1]
            minRightX=  float('inf') if partX == x else A[partX]
            
            maxLeftY = -float('inf') if partY == 0 else B[partY-1]
            minRightY=  float('inf') if partY == y else B[partY]

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if (x+y)%2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY))/2
                else:
                    return max(maxLeftX, maxLeftY)
            elif maxLeftX > minRightY:
                hi = partX-1
            else:
                lo = partX+1
        return 0

# tutorial: https://www.youtube.com/watch?v=LPFhl65R7ww&t=1013s