# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        def generate(L, R):
            if L > R: return [None]
            trees = []
            for root in range(L, R+1):
                lefts = generate(L, root-1)
                rights = generate(root+1, R)

                for left in lefts:
                    for right in rights:
                        node = TreeNode(root)
                        node.left = left
                        node.right = right
                        trees.append(node)
            return trees

        return generate(1, n) if n else []
