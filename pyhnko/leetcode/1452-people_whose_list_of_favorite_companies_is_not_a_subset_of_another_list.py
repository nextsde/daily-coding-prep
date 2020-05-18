class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        is_subset = set()
        
        for i in range(len(favoriteCompanies)):
            favoriteCompanies[i] = set(favoriteCompanies[i])

        for i, A in enumerate(favoriteCompanies):
            for j, B in enumerate(favoriteCompanies):
                if i == j: continue
                    
                if B < A: is_subset.add(j)
                if B == A: 
                    is_subset.add(i)
                    is_subset.add(j)
                    
        ans = []
        for i in range(len(favoriteCompanies)):
            if i not in is_subset: ans.append(i)
        
        return ans