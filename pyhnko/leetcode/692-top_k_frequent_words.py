# 692. Top K Frequent Words
class Word:
    def __init__(self, k, v):
        self.k = k
        self.v = v
    
    def __lt__(self, other):
        if self.v == other.v: return self.k > other.k
        return self.v < other.v
    
class Solution:
    def topKFrequent(self, words: List[str], K: int) -> List[str]:
        from collections import Counter
        from queue import PriorityQueue
        
        pq = PriorityQueue()
        cnt = 0
        for k, v in Counter(words).items():
            pq.put(Word(k, v))
            cnt += 1
            
            if cnt > K:
                pq.gt()
                cnt -= 1
        
        ans = []
        while not pq.empty(): ans.append(pq.get())
        
        return [w.k for w in ans[::-1]]