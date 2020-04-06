class Solution(object):
    def ladderLength(self, begin, end, words):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        from collections import defaultdict

        graph = defaultdict(list)

        for word in words:
            for i in range(len(word)):
                graph[word[:i] + '*' + word[i+1:]].append(word)

        queue = [(begin, 1)]
        seen = {begin, }

        while queue:
            word, d = queue.pop(0)
            if word == end: return d

            for i in range(len(word)):
                next = word[:i] + '*' + word[i+1:]
                for w in graph[next]:
                    if w not in seen:
                        queue.append((w, d+1))
                        seen.add(w)

        return 0
