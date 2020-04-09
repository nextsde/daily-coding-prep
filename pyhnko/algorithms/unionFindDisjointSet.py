class UnionFind:
    def __init__(self, N):
        self.parent = [i for i in range(N)]
        self.rank = [0]*N
        self.circles = N

        
    def find(self, idx):
        if self.parent[idx] == idx: return idx
        p = self.find(self.parent[idx])
        self.parent[idx] = p
        return p
    
    def union(self, a, b):
        x, y = self.find(a), self.find(b)
        if x != y:
            self.circles -= 1
            if self.rank[x] > self.rank[y]:
                self.parent[y] = x
            else:
                self.parent[x] = y
                
                if self.rank[x] == self.rank[y]:
                    self.rank[y] += 1
    
    def get_circles(self):
        return self.circles