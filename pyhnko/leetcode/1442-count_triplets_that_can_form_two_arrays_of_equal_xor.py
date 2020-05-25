class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        N = len(arr)
        arr.insert(0, 0)
        for i in range(1, N+1):
            arr[i] ^= arr[i-1]

        ans = 0
        for i in range(N-1):
            for k in range(i+1, N):
                if arr[i] == arr[k+1]:
                    ans += k-i
        
        return ans