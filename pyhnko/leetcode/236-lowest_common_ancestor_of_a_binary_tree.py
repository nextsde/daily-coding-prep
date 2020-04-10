# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def find(root, p_val, q_val):
            if not root: return None
            
            left, right = find(root.left, p.val, q_val), find(root.right, p_val, q_val)
            
            if root.val == p_val or root.val == q_val: return root
            
            if not left and not right: return None
            if not left or not right: return left if left else right
            
            return root
    
        return find(root, p.val, q.val)
            
            