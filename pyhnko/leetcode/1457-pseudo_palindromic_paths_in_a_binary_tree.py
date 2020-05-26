# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: TreeNode) -> int:
        from collections import Counter
        
        def pseudo_palindrome(A):
            odd = 0
            for k, v in Counter(A).items():
                if v&1: odd += 1
            return odd < 2
    
        def dfs(root, curr):
            if not root: return 0
            curr = curr + [root.val]
            if not root.left and not root.right:
                return pseudo_palindrome(curr) * 1
            return dfs(root.left, curr) + dfs(root.right, curr)
    
        return dfs(root, [])