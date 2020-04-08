class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        first = second = None
        first_count = 0
        second_count = 0
        
        for n in nums:
            if n == first:
                first_count += 1
            elif n == second:
                second_count += 1
            elif first_count == 0:
                first, first_count = n, 1
            elif second_count == 0:
                second, second_count = n, 1
            else:
                first_count -= 1
                second_count -= 1
                
        ans = []
        # check the solutions are correct
        if first != None and second != None:
        
            first_freq = sum((1 for n in nums if n == first))
            second_freq = sum((1 for n in nums if n == second))
            
            
            if first_freq > len(nums)//3: ans.append(first)
            if second_freq > len(nums)//3 and second not in ans: ans.append(second)
            
        elif first != None or second != None: 
            d = first if first!=None else second
            
            d_freq = sum((1 for n in nums if n == d))
            
            if d_freq > len(nums)//3: ans.append(d)
        
        return ans