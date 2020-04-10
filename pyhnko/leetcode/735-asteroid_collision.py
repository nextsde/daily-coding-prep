class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        def same_signal(a, b):
            return (a <0 and b < 0) or (a>=0 and b>=0)
        
        stack = []
        i = 0
        to_continue = True
        while i < len(asteroids):
            if to_continue:
                asteroid = asteroids[i]
   
            if not stack or same_signal(asteroid, stack[-1]): 
                stack.append(asteroid)
                i+=1
                to_continue = True
            else:
                # append if <- and ->                
                if stack[-1] <0 and asteroid >0: 
                    stack.append(asteroid)
                    i += 1
                    to_continue = True
                
                # both explote
                elif abs(stack[-1]) == abs(asteroid): 
                    stack.pop()
                    i+=1
                    to_continue = True

                # 
                elif not same_signal(stack[-1], asteroid) and abs(stack[-1]) < abs(asteroid): 
                    stack.pop()
                    to_continue = False
                else:
                    i += 1
                    to_continue = True
                
                    
        return stack
                
        
