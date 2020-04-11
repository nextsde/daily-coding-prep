class Solution:
    def distributeCandies(self, candies: List[int]) -> int:
        diff_candies = len(set(candies))
        
        if diff_candies > len(candies)//2: 
            return len(candies)//2
        return diff_candies