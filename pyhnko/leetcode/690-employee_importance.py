"""
# Employee info
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], ID: int) -> int:
        from collections import defaultdict
        
        def get_importance(id):
            if not subordinates[id]: return value[id]
            total = value[id]
            for sub in subordinates[id]:
                total += get_importance(sub)
            return total
        
        value = defaultdict(int)
        subordinates = defaultdict(list)
        for e in employees:
            id, val, sub = e.id, e.importance, e.subordinates
            value[id] = val
            subordinates[id].extend(sub)
        
        return get_importance(ID)