class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head: return None
        
        p = head
        even_head = ListNode(0)
        even = even_head
        
        while p.next and p.next.next:
            even.next = p.next
            p.next = p.next.next
            
            even = even.next
            p = p.next
        if p: even.next = p.next
            
        p.next = even_head.next
        
        return head