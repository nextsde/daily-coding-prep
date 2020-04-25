class FreqStack:
    from collections import defaultdict
    
    def __init__(self):
        self.freq = defaultdict(int)
        self.max_freq = 0
        self.stack = defaultdict(list)

    def push(self, x: int) -> None:
        f = self.freq[x] + 1
        self.freq[x] = f
        if f > self.max_freq:
            self.max_freq = f
        self.stack[f].append(x)
        

    def pop(self) -> int:
        val = self.stack[self.max_freq].pop()
        self.freq[val] -= 1
        if not self.stack[self.max_freq]:
            self.max_freq -= 1
        return val