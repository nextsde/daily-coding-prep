class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def solve(idx, curr):
            if idx == len(nums):
                possible = tuple(curr)
                if possible not in seen:
                    seen.add(possible)
            else:
                for i in range(idx, len(nums)):
                    curr[i], curr[idx] = curr[idx], curr[i]
                    solve(idx+1, curr)
                    curr[i], curr[idx] = curr[idx], curr[i]
        
        seen = set()
        solve(0, nums)
        return list(seen)
                    
        
"""
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        unordered_set<string> seen;
        vector<vector<int>> ans;
        permute(0, nums.size(), seen, ans, nums);
        return ans;
    }
    void permute(int idx, int N, unordered_set<string>&seen, vector<vector<int>>& ans, vector<int>& nums){
        if(idx == N){
            string aux = "";
            for_each(nums.begin(), nums.end(),
                    [&](auto const &i){
                       aux += '0' + i;
                    });

            if(seen.find(aux) == seen.end()){
                seen.insert(aux);
                vector<int> a = nums;
                ans.push_back(a);
            }
        }else{
            for(int i=idx; i<N; i++){
                swap(nums[i], nums[idx]);
                permute(idx+1, N, seen, ans, nums);
                swap(nums[i], nums[idx]);
            }
        }
    }
};

"""