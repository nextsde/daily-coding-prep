class FenwichTree:
    def __init__(self, arr):
        self.tree = [0] + arr # index starting at 1
        for i in range(1, len(self.tree)):
            j = i+(i&-i)
            if j < len(self.tree):
                self.tree[j] +=  self.tree[i]

    def prefix_sum(self, idx):
        result = 0
        while idx:
            result += self.tree[idx]
            idx -= (idx&-idx)
        return result

    def sum(self, L, R): #[L, R]
        return self.prefix_sum(R) - self.prefix_sum(L-1)

    def add(self, idx, value):
        while idx < len(self.tree):
            self.tree[idx] += value
            idx += (idx&-idx)

    def update(self, idx, value):
        prev = self.sum(idx, idx)
        self.add(idx, value-prev)

# Main observations:
#   - Array index starts at 1 not at 0
#   - leetcode problem related: https://leetcode.com/problems/range-sum-query-mutable/
#   - full course: https://www.youtube.com/watch?v=RgITNht_f4Q&t=419s
