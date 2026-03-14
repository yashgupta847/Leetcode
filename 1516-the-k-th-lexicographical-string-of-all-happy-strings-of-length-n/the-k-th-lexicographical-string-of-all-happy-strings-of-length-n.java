// class Solution {

//     public StringBuilder[] f(StringBuilder s, int[] i, StringBuilder[] arr, char prev , int n) {
        
//         if (s.length() == n) {
//             arr[i[0]] = new StringBuilder(s);
//             i[0]++;
//             return arr;
//         }
//         if (prev != 'a') {
//             s.append('a');
//             arr = f(s, i, arr, 'a' , n);
//             s.deleteCharAt(s.length() - 1);
//         }  if (prev != 'b') {
//             s.append('b');
//             arr = f(s, i, arr, 'b' , n);
//             s.deleteCharAt(s.length() - 1);
//         } if(prev != 'c') {
//             s.append('c');
//             arr = f(s, i, arr, 'c' , n);
//             s.deleteCharAt(s.length() - 1);
//         }
//         return arr;
//     }

//     public String getHappyString(int n, int k) {
//         StringBuilder arr[] = new StringBuilder[3 * (int) Math.pow(2, n - 1)];
//         if (k > arr.length)
//             return "";
//         StringBuilder s = new StringBuilder();
        
//         int[] i = new int[1];
//         arr = f( s , i , arr , '\0' ,n);
//         Arrays.sort(arr);
//         return arr[k-1].toString();
//     }
// }

class Solution {

    public int f(StringBuilder s, int i, StringBuilder[] arr, char prev, int n) {

        if (s.length() == n) {
            arr[i] = new StringBuilder(s);
            return i + 1;
        }

        if (prev != 'a') {
            s.append('a');
            i = f(s, i, arr, 'a', n);
            s.deleteCharAt(s.length() - 1);
        }

        if (prev != 'b') {
            s.append('b');
            i = f(s, i, arr, 'b', n);
            s.deleteCharAt(s.length() - 1);
        }

        if (prev != 'c') {
            s.append('c');
            i = f(s, i, arr, 'c', n);
            s.deleteCharAt(s.length() - 1);
        }

        return i;
    }

    public String getHappyString(int n, int k) {

        StringBuilder arr[] = new StringBuilder[3 * (int) Math.pow(2, n - 1)];

        if (k > arr.length)
            return "";

        StringBuilder s = new StringBuilder();

        f(s, 0, arr, '\0', n);

        Arrays.sort(arr);

        return arr[k - 1].toString();
    }
}