class Solution:
    def lengthLongestPath(self, input: str) -> int:
        stack = [(0, -1)]
        ans  = 0
        for element in input.split('\n'):
            level = element.count('\t')
            element = element[level:]

            # get the current level
            while level <= stack[-1][1]: stack.pop()

            if element.count('.'):
                curr = stack[-1][0] + len(element)
                ans = max(ans, curr)
                continue

            total = stack[-1][0] + len(element) + 1 #+1 is the '\'
            stack.append((total, level))

        return ans
