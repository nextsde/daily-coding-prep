# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or m>n: return None
        if n == m: return head
        
        new_head = ListNode(0)
        new_head.next = head
        prev = new_head
        
        curr = head
        cnt = 1
        while curr:
            if cnt == m:
                A = prev
                B = curr
                prev = None
                while cnt <= n:
                    cnt += 1
                    temp = curr.next
                    curr.next = prev
                    prev = curr
                    curr = temp
                A.next = prev   
                B.next = curr
                    
                break
            prev = prev.next
            curr = curr.next
            cnt += 1
        
        return new_head.next
        