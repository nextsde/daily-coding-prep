# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head: return None
        
        p_head, q_head = ListNode(0), ListNode(0)
        p, q, curr = p_head, q_head, head
        
        while curr:
            if curr.val < x:
                p.next = curr
                p = p.next
            else:
                q.next = curr
                q = q.next
            
            curr = curr.next
        q.next = None
        p.next = q_head.next
        
        return p_head.next
