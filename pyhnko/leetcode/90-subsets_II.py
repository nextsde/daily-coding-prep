class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        seen = set()
        for mask in range(2**(len(nums))):
            seen.add(
                tuple([nums[i] for i in range(len(nums)) if mask & (1<<i)])
            )
        
        return list(seen)

"""
class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        int N = nums.size();
        unordered_set<string> seen;
        vector<vector<int>> ans;
        
        sort(nums.begin(), nums.end());

        for(int mask=0; mask<pow(2, N); mask++){
            vector<int> aux;
            string aux_s = "";
            for(int i=0; i<N; i++){
                if(mask & (1<<i)){
                    aux.push_back(nums[i]);
                    aux_s += '0' + nums[i];
                    aux_s += '.';
                }
            }
            if(seen.find(aux_s) != seen.end()) continue;
            seen.insert(aux_s);
            ans.push_back(aux);
        }
        return ans;
    }
};
"""