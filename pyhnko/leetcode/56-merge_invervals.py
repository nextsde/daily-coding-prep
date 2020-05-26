class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) < 2: return intervals
        
        intervals.sort()
        ans = []
        L, R = intervals[0]
        for left, right in intervals[1:]:
            if left <= R:
                R = max(R, right)
            else:
                ans.append([L, R])
                L, R = left, right
        ans.append([L, R])
        return ans

"""
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size() < 2) return intervals;
        
        sort(intervals.begin(), intervals.end());
        
        vector<vector<int>> answer;
        int L = intervals[0][0], R = intervals[0][1];
        
        for(int i=1; i<intervals.size(); i++){
            int left = intervals[i][0], right = intervals[i][1];
            if(left <= R){
                R = max(R, right);
            }else{
                answer.push_back({L, R});
                L = left;
                R = right;
            }
        }
        answer.push_back({L, R});
        return answer;
    }
};
"""