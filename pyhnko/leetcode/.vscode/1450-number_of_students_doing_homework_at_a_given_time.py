class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        cnt = 0
        for start, end in zip(startTime, endTime):
            if start<=queryTime<=end: cnt += 1
        
        return cnt