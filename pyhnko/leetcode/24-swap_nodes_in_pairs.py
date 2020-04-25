class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head: return None
        
        new_head = ListNode(0)
        h = new_head
        h.next = head
        while h.next and h.next.next:
            temp = h.next
            h.next = h.next.next
            temp2 = h.next.next
            h.next.next = temp
            temp.next = temp2
            h = temp
        return new_head.next