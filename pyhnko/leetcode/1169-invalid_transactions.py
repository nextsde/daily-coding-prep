class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        s = set()
        r = []
        for item in transactions:
            name, time, amount, city = item.split(',')
            r.append([name, int(time), int(amount), city, item])
            
        import operator
        r = sorted(r, key = operator.itemgetter(0,1))
        
        for i in range(len(r)):
            item = r[i]
            if item[2]>1000:
                s.add(item[4])
            j = i+1
            while j < len(r) and item[0] == r[j][0] and item[1]+60>=r[j][1]:
                if item[3] != r[j][3]:
                    s.add(item[4])
                    s.add(r[j][4])
                j += 1
        
        return list(s)