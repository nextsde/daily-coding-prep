class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        cities_to_i = {}
        i_to_cities = {}
        i = 0
        for src, dest in paths:
            if src not in cities_to_i:
                cities_to_i[src] = i
                i_to_cities[i] = src
                i += 1
            if dest not in cities_to_i:
                cities_to_i[dest] = i
                i_to_cities[i] = dest
                i += 1
        
        out_degree = [0]*len(cities_to_i)
        
        for src, dest in paths:
            out_degree[cities_to_i[src]] += 1
        
        for i, val in enumerate(out_degree):
            if not val:
                return i_to_cities[i]
        
        return ''