# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root: return []
        
        queue = [root]
        ans = []
        
        while queue:
            size = len(queue)
            while size:
                size -= 1
                node = queue.pop(0)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
                
                val = node.val
            ans.append(val)
        
        return ans