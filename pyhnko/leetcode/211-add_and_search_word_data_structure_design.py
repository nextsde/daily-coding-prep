class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = Trie()


    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        self.trie.insert(word)


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.trie.search(word)

class Trie:
    def __init__(self):
        self.trie = {}

    def insert(self, word):
        trie = self.trie
        for w in word:
            if w not in trie:
                trie[w] = {}
            trie = trie[w]
        trie['*'] = True

    def search(self, word):
        def find(d, idx):
            if idx == len(word):
                return '*' in d
            else:
                if word[idx] == '.':
                    for k, v in d.items():
                        if k == '*': continue
                        if find(v, idx+1):
                            return True
                elif word[idx] in d:
                    return find(d[word[idx]], idx+1)

            return False


        trie = self.trie
        return find(trie, 0)






# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
