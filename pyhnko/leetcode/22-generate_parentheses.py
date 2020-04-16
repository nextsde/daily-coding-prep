class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def generate(l, r, curr, solutions):
            if l == 0 and r == 0:
                solutions.append(curr)
            else:
                # 2 1
                if l == 0:
                    generate(l, r-1, curr+')', solutions)
                elif l <= r:
                    generate(l-1, r, curr+'(', solutions)
                    generate(l, r-1, curr+')', solutions)
        
        ans = []
        generate(n, n, '', ans)
        return ans