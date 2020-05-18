class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        from collections import deque
        
        if not root: return []
        
        queue = deque([root])
        
        ans = []
        while queue:
            size = len(queue)
            n = -float('inf')
            while size:
                size -= 1
                node = queue.popleft()
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
                
                n = max(n, node.val)
            
            ans.append(n)
                
        return ans
