class Sort(str):
    def __lt__(self, other):
        return len(self) < len(other)

class Solution:
    def arrangeWords(self, text: str) -> str:
        A = text.split()
        A = ' '.join(sorted(A, key=Sort)).lower()
        return A[0].upper() + A[1:]
        