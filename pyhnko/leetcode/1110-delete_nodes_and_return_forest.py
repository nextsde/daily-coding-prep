# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        import collections
        if not root: return []
        
        queue = collections.deque([root])
        parent = {}
        ans = []
        to_delete = set(to_delete)
        if root.val not in to_delete:
            ans.append(root)
        while queue:
            node = queue.popleft()
            
            if node.left:
                parent[node.left.val] = node
            if node.right:
                parent[node.right.val] = node
            if node.val in to_delete:
                # check if it has parent
                if node.val in parent:
                    # left
                    if parent[node.val].left and parent[node.val].left.val == node.val:
                        parent[node.val].left = None
                    #right
                    else:
                        parent[node.val].right = None
                
                if node.left:
                    if node.left.val not in to_delete: ans.append(node.left)
                    queue.append(node.left)
                if node.right:
                    if node.right.val not in to_delete: ans.append(node.right)
                    queue.append(node.right)
            else:
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return [r for r in ans if r]
        