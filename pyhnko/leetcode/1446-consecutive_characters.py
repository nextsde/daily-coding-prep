class Solution:
    def maxPower(self, S: str) -> int:
        if not S: return 0
        
        prev = S[0]
        cnt = total = 1
        for s in S[1:]:
            if s == prev:
                cnt += 1
                total = max(cnt, total)
            else:
                prev = s
                cnt = 1
        return total
"""
class Solution {
public:
    int maxPower(string S) {
        if(S.size() == 0) return 0;
        
        char prev = S[0];
        int cnt=1, total=1;
        for(int i=1; i<S.size(); i++){
            if(S[i] == prev){
                total = max(total, ++cnt);
            }else{
                cnt = 1;
                prev = S[i];
            }
            
        }
        return total;
    }
};
"""

