class UnionFind:
    def __init__(self):
        self.p = [i for i in range(26)]
        self.r = [0 for i in range(26)]
        
    def find(self, i):
        if self.p[i] == i: return i
        new_i = self.find(self.p[i])
        self.p[i] = new_i
        return new_i
    
    def union(self, a, b):
        # convert to numbers
        a = ord(a) - ord('a')
        b = ord(b) - ord('a')
        x, y = self.find(a), self.find(b)
        if x != y:
            if self.r[y] > self.r[x]:
                self.p[y] = x
            else:
                self.p[x] = y
                if self.r[x] == self.r[y]:
                    self.r[y] += 1
    
    def valid(self, a, b):
        # convert to numbers
        a = ord(a) - ord('a')
        b = ord(b) - ord('a')
        return self.find(a) != self.find(b)

class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        if not equations: return True
        
        distincts =[]
        unionFind = UnionFind()
        
        for equation in equations:
            if '==' in equation:
                unionFind.union(equation[0], equation[-1])
            else:
                distincts.append((equation[0], equation[-1]))
        
        for distinct in distincts:
            if not unionFind.valid(*distinct): return False
    
        return True
        