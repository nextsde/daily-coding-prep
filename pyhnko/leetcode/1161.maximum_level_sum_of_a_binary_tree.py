# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        if not root: return 0
        
        queue = [root]
        max_, ans = -float('inf'), 0
        
        level = 1
        while queue:
            size = len(queue)
            current = 0
            while size:
                size -= 1
                node = queue.pop(0)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
                current += node.val
            
            if current > max_:
                max_ = current
                ans = level
                
            level += 1
        
        return ans
        