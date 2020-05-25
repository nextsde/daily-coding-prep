class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        dp = [0] + [-1] * (target)
        
        for i in range(1, target+1):
            for e, c in enumerate(cost, 1):
                if i-c>=0:
                    dp[i] = max(dp[i], dp[i-c]*10+e)
        
        return str(max(dp[target], 0))
"""
class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        vector<int> dp(target+1, INT_MIN);
        dp[0] = 0;
        for(int t=1; t<=target; t++){
            for(int i=0; i<9; i++){
                if(t - cost[i] >= 0)
                    dp[t] = max(dp[t], dp[t - cost[i]]+1);
            }
        }
        if(dp[target] < 0) return "0";
        string ans = "";
        for(int i=8; i>=0; i--){
            while(target>=cost[i] and dp[target] == dp[target - cost[i]] + 1){
                ans += ('1' + i);
                target -= cost[i];
            }
        }
        return ans;
    }
};
"""