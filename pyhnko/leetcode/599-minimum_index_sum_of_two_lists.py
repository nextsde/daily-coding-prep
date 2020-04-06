class Solution:
    def findRestaurant(self, Andy: List[str], Doris: List[str]) -> List[str]:
        andy = {}
        for i, restaurant in enumerate(Andy):
            andy[restaurant] = i

        idx = float('inf')
        ans =  []
        for i, doris in reversed(list(enumerate(Doris))):
            if doris in andy and andy[doris]+i <= idx:
                idx = andy[doris]+i

        for i, doris in reversed(list(enumerate(Doris))):
            if doris in andy and andy[doris]+i == idx:
                ans.append(doris)

        return ans
