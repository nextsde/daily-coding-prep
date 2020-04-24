class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.H = bytearray(125000)
        
    def add(self, key: int) -> None:
        d, r = divmod(key, 8)
        self.H[d] |= (1<<r)

    def remove(self, key: int) -> None:
        d, r = divmod(key, 8)
        self.H[d] &= ~(1<<r)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        d, r = divmod(key, 8)
        return self.H[d] & (1<<r)

""" class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.H = [None]*10000
        
    def add(self, key: int) -> None:
        d, r = divmod(key, 10000)
        if self.H[d] == None:
            self.H[d] = ListNode(key)
        else:
            head = prev = ListNode(0)
            prev.next = curr = self.H[d]

            while curr:
                if curr.val == key: return
                prev = curr
                curr = curr.next
            prev.next = ListNode(key)
            self.H[d] = head.next

    def remove(self, key: int) -> None:
        d, r = divmod(key, 10000)
        if not self.H[d]: return
        head = prev = ListNode(0)
        prev.next = curr = self.H[d]
        while curr:
            if curr.val == key:
                prev.next = curr.next
                break
            prev = curr
            curr = curr.next
        
        self.H[d] = head.next

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        d, r = divmod(key, 10000)
        if not self.H[d]: return False
        curr = self.H[d]
        
        while curr:
            if curr.val == key: return True
            curr = curr.next
        
        return False
 """