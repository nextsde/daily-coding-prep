class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:
        def kadane(A):
            curr = total = -float('inf')
            for n in A:
                curr = max(n, curr+n)
                total = max(total, curr)
            
            return total
        
        s = sum(A)
        if all(True if n<0 else False for n in A): return max(A)
        ans1 = s + kadane(-n for n in A)
        ans2 = kadane(A)
        
        return max(ans1, ans2)

"""
class Solution {
public:
    int maxSubarraySumCircular(vector<int>& A) {
        int sum = 0;
        int currMax=-1e6, totalMax=-1e6, currMin=1e6, totalMin=1e6;
        for(int i=0; i<A.size(); i++){
            sum += A[i];
            
            // max
            currMax = max(currMax + A[i], A[i]);
            totalMax = max(totalMax, currMax);
            
            // min
            currMin = min(currMin + A[i], A[i]);
            totalMin = min(totalMin, currMin);
        }
        
        return (totalMax < 0) ? totalMax: max(totalMax, sum - totalMin);
    }
};

"""