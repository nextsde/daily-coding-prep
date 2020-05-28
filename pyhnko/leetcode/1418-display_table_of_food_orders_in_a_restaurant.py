class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        from collections import defaultdict
        
        dishes = set()
        table = defaultdict(dict)
        
        for _, table_id, dish_name in orders:
            dishes.add(dish_name)
            table_id = int(table_id)
            table[table_id][dish_name] = table[table_id].get(dish_name, 0) + 1
            
        dishes_ordered = ["Table"] + [dish for dish in sorted(list(dishes))]
        ans = [dishes_ordered]
        
        for table_id in sorted(table.keys()):
            aux = [str(table_id)]
            for dish in dishes_ordered[1:]:
                n = table[table_id][dish] if dish in table[table_id] else 0
                aux.append(str(n))
            ans.append(aux)
        
        
        
        return ans