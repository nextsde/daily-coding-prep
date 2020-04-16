class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits = []
        r  = []
        for l in logs:
            id_, rest = l.split(' ', 1)
            if rest[0].isdigit():
                digits.append(l)
            else:
                r.append(l)
        
        return sorted(r, key=lambda x: (x.split(' ',1)[1], x.split(' ')[0])) + digits