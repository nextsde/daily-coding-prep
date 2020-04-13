class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        import math
        
        if len(points) < 2: return len(points)
        
        points.sort()
        max_points = 0
        for i in range(len(points)-1):
            x1, y1 = points[i]
            
            same, vertical, horizontal = 1, 0, 0
            slope = {}

            for x2, y2 in points[i+1:]:
                
                if x1 == x2 and y1 == y2:
                    same += 1
                elif x1 == x2 or y1 == y2:
                    if x1 == x2: vertical += 1
                    else: horizontal += 1
                else:
                    dx, dy = x2-x1, y2-y1
                    gcd = math.gcd(dx, dy)
                    dx, dy = dx//gcd, dy//gcd
                    
                    slope[(dx, dy)] = slope.get((dx, dy), 0) + 1
                    
                    max_points = max(max_points, slope[(dx, dy)] + same)
            
            max_points = max(max_points, same + horizontal)
            max_points = max(max_points, same + vertical)
        
        return max_points