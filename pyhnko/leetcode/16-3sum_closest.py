class Solution:
    def threeSumClosest(self, A: List[int], T: int) -> int:
        A.sort()
        ans = diff_min = float('inf')
        
        for i, val in enumerate(A[:-2]):
            l, r = i+1, len(A)-1
            while l < r:
                p = A[l] + A[r] + val
                
                if abs(p - T) < diff_min:
                    diff_min = abs(p - T)
                    ans = p
                
                if p >= T: r-=1
                else:      l+=1
            
        
        return ans
"""
class Solution {
public:
    int threeSumClosest(vector<int>& A, int T) {
        sort(A.begin(), A.end());
        int l, r, p, diff_min=INT_MAX, ans;
        
        for(int i=0; i<A.size()-2; i++){
            l = i+1; 
            r = A.size()-1;
            
            while(l<r){
                p = A[l] + A[r] + A[i];
                if(abs(p - T) < diff_min){
                    diff_min = abs(p - T);
                    ans = p;
                }
                (p >= T) ? r-- : l++;
            }
        }
        return ans;
    }
};
"""


"""
impl Solution {
    pub fn three_sum_closest(A: Vec<i32>, T: i32) -> i32 {
        let mut diff_min = i32::max_value();
        let mut ans = 0;
        let mut l; let mut r; let mut p;
        let mut A = A;
        
        A.sort();
        for i in 0..A.len()-2{
            l = i+1;
            r = A.len()-1;
            
            while l<r{
                p = A[i] + A[l] + A[r];
                if (p - T).abs() < diff_min{
                    diff_min = (p - T).abs();
                    ans = p;
                }
                if p >= T{
                    r -= 1;
                }else{
                    l += 1;
                }
            }
        } 
        
        
        return ans;
    }
}
"""