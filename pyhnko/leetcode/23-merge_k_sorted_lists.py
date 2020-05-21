# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, L: List[ListNode]) -> ListNode:
        L = [head for head in L if head]
        if not L: return None
        
        head = ListNode(0)
        curr = head
        while L:
            m = float('inf')
            i = 0
            idx = 0
            while i < len(L):
                if L[i].val < m:
                    m = L[i].val
                    idx = i
                i += 1
                
            curr.next = L[idx]
            curr = curr.next
            
            if not L[idx].next:
                del L[idx]
            else:
                L[idx] = L[idx].next
        
        return head.next
        