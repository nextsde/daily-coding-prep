class Trie:
    def __init__(self):
        self.trie = {}

    def insert(self, number):
        trie = self.trie
        for bit in number:
            if bit not in trie:
                trie[bit] = {}
            trie = trie[bit]
        trie['*'] = True

    def query(self, number):
        ans = ''
        trie = self.trie
        for bit in number:
            if bit == '0':
                if '1' in trie:
                    trie = trie['1']
                    ans = ans + '1'
                else:
                    trie = trie['0']
                    ans = ans + '0'
            else:
                if '0' in trie:
                    trie = trie['0']
                    ans = ans + '0'
                else:
                    trie = trie['1']
                    ans = ans + '1'
        return int(ans, 2)

class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        to_bin = lambda n: f'{n:032b}'

        trie = Trie()
        for n in nums:
            trie.insert(to_bin(n))
        ans = 0
        for n in nums:
            ans = max(ans, n^trie.query(to_bin(n)))

        return ans

        
