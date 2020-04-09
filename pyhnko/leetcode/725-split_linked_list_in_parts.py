# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def splitListToParts(self, head: ListNode, k: int) -> List[ListNode]:
        def size(head):
            cnt = 0
            p = head
            while p:
                p = p.next
                cnt += 1
            return cnt
        
        length = size(head)
        
        widht, remainder = divmod(length, k)
        curr = head
        
        ans = []
        for i in range(k):
            head = ListNode(0)
            p = head
            for _ in range(widht + (i<remainder)*1 ): # <----------------------
                p.next = ListNode(curr.val)
                p = p.next
                curr = curr.next
            ans.append(head.next)
        
        return ans
            