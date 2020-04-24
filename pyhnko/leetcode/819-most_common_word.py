class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        import re
        freq = {}
        max_freq = 0
        ans = ''
        paragraph = re.sub('\W', ' ', paragraph).lower()
        for word in paragraph.split():
            freq[word] = freq.get(word, 0) + 1
            
            if max_freq < freq[word] and word not in banned:
                max_freq = freq[word]
                ans = word
        return ans