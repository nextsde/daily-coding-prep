class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        ans = []
        
        n = min(n, target[-1])
        for i in range(1, n+1):
            ans.append('Push')
            
            if i not in target:
                ans.append('Pop')
        
        return ans

"""
class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        vector<string> ans;
        n = min(n, target[target.size()-1]);
        int i = 0;
        unordered_set<int> seen(target.begin(), target.end());
        for(int i=1; i<=n; i++){
            ans.push_back("Push");
            if(seen.find(i) == seen.end()){
                ans.push_back("Pop");
            }
        }
        return ans;
    }
};
"""