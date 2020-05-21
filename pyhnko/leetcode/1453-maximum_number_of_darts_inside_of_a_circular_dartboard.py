class Solution:
    def numPoints(self, points: List[List[int]], r: int) -> int:
        def get_circles(p1, p2, r):
            x1, y1, x2, y2 = *p1, *p2
            dx, dy = x1-x2, y1-y2
            
            # distance between p1 and p2
            distance = (dx**2 + dy**2)**0.5
            
            # too far
            if distance  > 2*r: return []
            
            # center
            x3, y3 = (x1+x2)/2, (y1+y2)/2
            
            # pitagoras a^2 + b^2 = h^2 -> b = (h^2 - a^2)^0.5
            # a=distance/2, h=r
            a = distance/2
            b = (r**2 - a**2)**0.5
            
            yield [x3 + (b*dy)/distance, y3 - (b*dx)/distance]
            yield [x3 - (b*dy)/distance, y3 + (b*dx)/distance]
        
        total = 0
        for i in range(len(points)):
            
            for j in range(len(points)):
                if i == j: continue
                for h, k in get_circles(points[i], points[j], r):
                    cnt = 0
                    for x, y in points:
                        # (x-h)^2 + (y-k)^2 = r^2 -> circle equation
                        if (x-h)**2 + (y-k)**2 <= r**2 + 10**-6: # to avoid floating point error
                            cnt += 1
                
                    total = max(total, cnt)
    
        return 1 if total == 0 else total