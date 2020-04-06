class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        diff = [g-c for g, c in zip(gas, cost)]

        if sum(diff) < 0: return -1
        n = len(gas)
        accumulate = list(itertools.accumulate(diff))
        return (min(range(n), key=lambda i: accumulate[i]) + 1) % n

        
