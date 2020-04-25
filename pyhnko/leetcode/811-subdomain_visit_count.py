class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        dom = {}
        
        for domain in cpdomains:
            num, full = domain.split(' ')
            num = int(num)
            full = full.split('.')
            for i in range(len(full)):
                aux = '.'.join(full[i:])
                dom[aux] = dom.get(aux, 0) + num
        
        return [f'{v} {k}' for k, v in dom.items()]