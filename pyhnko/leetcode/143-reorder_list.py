""" space O(N)
class Solution:
    def reorderList(self, head: ListNode) -> None:
        # Do not return anything, modify head in-place instead.
        Arr = []
        p = head
        while p:
            Arr.append(p)
            p = p.next
        
        new_head = ListNode(0)
        p = new_head
        first = 1
        while Arr:
            node = Arr.pop(0) if first else Arr.pop()
            first = 1- first
            p.next = node
            p = p.next
        
        p.next = None
        
        head = new_head.next
 """
# space O(1) Get the middle and reverse it, then merge both
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        def reverse(head):
            prev, curr = None, head
            while curr:
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
            return prev

        if not head: return None
        
        p = q = head
        while p.next and p.next.next:
            q = q.next
            p = p.next.next
        
        mid = q.next
        q.next = None
        mid = reverse(mid)
        new_head = ListNode(0)
        p = new_head
        
        first = 1
        while head or mid:
            p.next = head if first else mid
            if first:
                head = head.next
            else:
                mid = mid.next
            first = 1-first
            p = p.next
        
        
        head = new_head.next
        
        
            