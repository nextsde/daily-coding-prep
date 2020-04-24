class ListNode:
    def __init__(self, k, v):
        self.val = v
        self.key = k
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.H = [None] * 10000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        d, r = divmod(key, 10000)
        if self.H[d] == None:
            self.H[d] = ListNode(key, value)
        else:
            head = prev = ListNode(0, 0)
            prev.next = curr = self.H[d]
            while curr:
                if curr.key == key: 
                    curr.val = value
                    return
                prev = curr
                curr = curr.next
            prev.next = ListNode(key, value)
            self.H[d] = head.next
                
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        d, r = divmod(key, 10000)
        if not self.H[d]: return -1
        curr = self.H[d]
        while curr:
            if curr.key == key: return curr.val
            curr = curr.next
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        d, r = divmod(key, 10000)
        if not self.H[d]: return
        head = prev = ListNode(0, 0)
        prev.next = curr = self.H[d]
        
        while curr:
            if curr.key == key:
                prev.next = curr.next
                break
            prev = curr
            curr = curr.next
        
        self.H[d] = head.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)