class Solution:
    def restoreIpAddresses(self, ip: str) -> List[str]:
        def back(idx, curr):
            if len(curr) > 4: return
            if idx == len(ip) and len(curr) == 4:
                ans.append('.'.join(curr))
            else:
                for i in range(3):
                    p = idx+i
                    if p < len(ip):
                        sub = ip[idx:p+1]
                        if int(sub) < 256:
                            if len(sub)>1 and sub[0] == '0': continue
                            back(p+1, curr + [sub])
        
        ans = []
        back(0, [])
        return ans