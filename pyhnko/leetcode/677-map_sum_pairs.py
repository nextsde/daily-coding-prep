class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}


    def insert(self, key: str, val: int) -> None:
        trie = self.trie
        for k in key:
            if k not in trie:
                trie[k] = {}
            trie = trie[k]
        trie['*'] = val

    def sum(self, prefix: str) -> int:
        trie = self.trie
        for p in prefix:
            if p not in trie: return 0
            trie = trie[p]
        return self._sum_helper(trie)

    def _sum_helper(self, d):
        if not len(d): return 0
        ans = d.get('*', 0)
        for k, v in d.items():
            if k == '*': continue
            ans += self._sum_helper(v)

        return ans


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
