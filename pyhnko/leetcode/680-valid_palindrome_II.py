class Solution:
    def validPalindrome(self, S: str) -> bool:
        def check(A):
            return A == A[::-1]
        l, r = 0, len(S)-1
        while l < r and S[l] == S[r]:
            l += 1; r -= 1;
        
        if l == r: return True
        return check(S[l:r]) or check(S[l+1:r+1])

"""
class Solution {
public:
    bool validPalindrome(string s) {
        int l=0, r=s.size()-1;
        while (l<r){
            if (s[l] != s[r]){
                return check(s.substr(l+1, r-l)) or check(s.substr(l, r-l));
            }
            l++; r--;
        }
        return true;
    }
    bool check(string s){
        int l=0, r=s.size()-1;
        while(l<r){
            if (s[l++] != s[r--])
                return false;
        }
        return true;
    }
};
"""

"""

impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        let mut s = s.as_bytes();
        let check = |s:&[u8], mut l:usize, mut r:usize|{
            while l < r{
                if s[l] != s[r]{return false;}
                l += 1;
                r -= 1;
            }
            return true;
        };   
        
        let mut l:usize = 0;
        let mut r:usize = s.len()-1;
        
        while l < r{
            if s[l] != s[r]{
                return check(s, l, r-1) || check(s, l+1, r);
            }
            l+=1;
            r-=1;
        }
        return true;
    }
}
"""