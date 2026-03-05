// class Solution {
//     public boolean isPalindrome(int x) {
//         if (x < 0)
//             return false;
//         int rev = 0;
//         int original = x;
//         while (original != 0) {
//             rev = rev * 10 + original % 10;
//             original /= 10;
//         }
//         if(rev == x) return true;
//         return false;
//     }
// }

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}