# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        new_head = ListNode(float('inf'))
        new_head.next = head
        
        prev = new_head
        curr = head
        
        while curr:
            if prev.val != curr.val:
                prev.next = curr
                prev = prev.next
            curr = curr.next
        if prev.next:
            prev.next = None
        
        return new_head.next
        
