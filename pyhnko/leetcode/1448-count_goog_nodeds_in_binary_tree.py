# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root, max_val):
            if not root: return
            if root.val >= max_val:
                self.cnt += 1
            max_val = max(root.val, max_val)
            dfs(root.left, max_val)
            dfs(root.right, max_val)
    
        self.cnt = 0
        dfs(root, -float('inf'))
        
        return self.cnt 

"""
class Solution {
public:
    int goodNodes(TreeNode* root) {
        int ans = 0;
        dfs(root, INT_MIN, &ans);
        return ans;
    }
    
    void dfs(TreeNode* root, int max_val, int* paths){
        if(!root) return;
        (*paths)+= (root->val >= max_val);
        max_val = max(max_val, root->val);
        dfs(root->left, max_val, paths);
        dfs(root->right, max_val, paths);
    }
};
"""