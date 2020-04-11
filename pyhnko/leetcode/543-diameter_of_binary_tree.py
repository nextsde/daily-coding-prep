# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        def diameter(root):
            if not root: return 0
            left = diameter(root.left)
            right = diameter(root.right)
            
            self.ans = max(self.ans, left+right)
            return max(left, right)+1
        self.ans = 0
        diameter(root)
        return self.ans