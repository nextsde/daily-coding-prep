# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        st_A, st_B = [], []
        while l1: 
            st_A.append(l1)
            l1 = l1.next
        while l2:
            st_B.append(l2)
            l2 = l2.next
        
        new_head = ListNode(0)
        curr = new_head
        carry = 0
        stack = []
        while st_A or st_B or carry:
            a = (st_A.pop()).val if st_A else 0
            b = (st_B.pop()).val if st_B else 0
            
            n = a+b+carry
            carry = n//10
            stack.append(ListNode(n%10))
        
        while stack:
            curr.next = stack.pop()
            curr = curr.next
        return new_head.next