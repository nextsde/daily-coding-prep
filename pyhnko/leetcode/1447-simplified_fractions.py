class Solution:
    def simplifiedFractions(self, N: int) -> List[str]:
        def gcd(a, b):
            return gcd(b, a%b) if b != 0 else abs(a)
        
        ans = []
        for n in range(1, N):
            for d in range(n+1, N+1): 
                if n != 1 and gcd(d, n) != 1: continue
                ans.append(f"{n}/{d}")
        
        return ans
"""
class Solution {
public:
    vector<string> simplifiedFractions(int N) {
        vector<string> ans;
        
        for(int n=1; n<N; n++){
            for(int d=n+1; d<=N; d++){
                if( d!= 1 and gcd(d, n) != 1) continue;
                string aux = to_string(n) + "/" + to_string(d);
                ans.push_back(aux);
            }
        }
        return ans;
    }
};
"""