class Solution:
    def isPalindromic(self, s: str) -> bool:
        a = ""
        for c in s:
            a += format(ord(c), '08b')
        return a == a[::-1]
