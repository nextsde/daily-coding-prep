class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0: return '0'
        
        value = []
        mp = {}
        # negative number
        if (numerator < 0 and denominator > 0) or (numerator > 0 and denominator < 0):
            value.append('-')
            numerator = -numerator
        
        div, rem = divmod(numerator, denominator)
        value.append(str(div))
        if rem: value.append('.')
        mp[rem] = len(value)
        while rem:
            rem *= 10
            div, rem = divmod(rem, denominator)
            value.append(str(div))
            if rem in mp:
                value.insert(mp[rem], '(')
                value.append(')')
                break
            mp[rem] = len(value)
            
            
            
        return ''.join(value)

