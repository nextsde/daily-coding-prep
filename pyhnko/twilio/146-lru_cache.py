class DoubleLinkedList:
    def __init__(self, key, value):
        self.prev = None
        self.next = None
        self.value = value
        self.key = key

class LRUCache:

    def __init__(self, capacity: int):
        self.head = DoubleLinkedList(0, 0)
        self.tail = DoubleLinkedList(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.location = {}

    def get(self, key: int) -> int:
        if key not in self.location: return -1
        
        node = self.location[key]
        self._remove(node)
        self._add(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.location: 
            node = self.location[key]
            node.value = value
            self._remove(node)
        else:
            node = DoubleLinkedList(key, value)
            self.location[key] = node

        self._add(node)
        if len(self.location) > self.capacity:
            to_remove = self.head.next
            self._remove(to_remove)
            del self.location[to_remove.key]
    
    def _add(self, node):
        temp = self.tail.prev
        temp.next = node
        node.prev = temp
        node.next = self.tail
        self.tail.prev = node
        
    def _remove(self, node):
        node = self.location[node.key]
        prev = node.prev
        next = node.next
        prev.next = next
        next.prev = prev


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

