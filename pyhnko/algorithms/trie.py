class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._trie = {}


    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        trie = self._trie
        for char in word:
            if char not in trie:
                trie[char] = {}
            trie = trie[char]
        trie['*'] = True


    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        trie = self._trie
        for char in word:
            if char not in trie:
                return False
            trie = trie[char]
        return True if '*' in trie else False



    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        trie = self._trie
        for char in prefix:
            if char not in trie:
                return False
            trie = trie[char]
        return True

# Main observations:
#   - The tree is a dictionary
#   - The '*' symbol means the until there there is a prefix
#   - full course: https://www.youtube.com/watch?v=zIjfhVPRZCg
#   - leetcode problems related:
#       * https://leetcode.com/problems/implement-trie-prefix-tree/
#       * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
#       * https://leetcode.com/problems/add-and-search-word-data-structure-design/
#       * https://leetcode.com/problems/longest-word-in-dictionary/
#       * https://leetcode.com/problems/map-sum-pairs/
