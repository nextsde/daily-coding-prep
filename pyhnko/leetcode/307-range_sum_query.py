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

class NumArray:

    def __init__(self, nums: List[int]):
        self.fenwich = FenwichTree(nums)

    def update(self, i: int, val: int) -> None:
        self.fenwich.update(i+1, val)

    def sumRange(self, i: int, j: int) -> int:
        return self.fenwich.sum(i+1, j+1)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)
