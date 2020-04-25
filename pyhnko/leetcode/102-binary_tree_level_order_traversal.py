# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        
        queue = [root]
        ans = []
        
        while queue:
            size = len(queue)
            curr_level = []
            while size:
                size -= 1
                node = queue.pop(0)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
                curr_level.append(node.val)
            ans.append(curr_level)
        return ans