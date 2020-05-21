# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        from collections import deque, Counter
        if not root1 or not root2: return False
        
        def get_leaves(root):
            if not root.left and not root.right:
                return [root.val]
            ans = []
            if root.left:
                ans.extend(get_leaves(root.left))   
            if root.right:
                ans.extend(get_leaves(root.right))   
            return ans
        return get_leaves(root1) == get_leaves(root2)