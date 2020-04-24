class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans = []
        while words:
            w = words.pop(0)
            counter = len(w)
            aux = []
            while words and counter + len(words[0]) + len(aux)+1 <= maxWidth:
                aux.append(words.pop(0))
                counter += len(aux[-1])
            aux.insert(0, w)
            
            if words: # it is not the last line
                remainder = maxWidth - counter
                if remainder:
                    n_spaces = len(aux)-1
                    if n_spaces > 0:
                        add, r = divmod(remainder, n_spaces)
                        for i, a in enumerate(aux[:-1]):
                            aux[i] = aux[i] + ' '*add
                            if i < r: aux[i] = aux[i] + ' '
                    else:
                        aux[0] = aux[0] + ' '* remainder
                ans.append(''.join(aux))
            else:
                line = ' '.join(aux)
                line = line + ' '*(maxWidth-len(line))
                ans.append(line)
                
        return ans