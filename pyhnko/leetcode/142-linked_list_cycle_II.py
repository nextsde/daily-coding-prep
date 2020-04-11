class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        
        slow = fast = head
        cycle = False
        
        while fast  and fast.next and not cycle:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                cycle = True
        
        if not cycle: return None
        
        p = head
        while p != slow:
            slow = slow.next
            p = p.next
        
        return p