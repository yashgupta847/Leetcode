class Solution {
    public int i = 0;

    public StringBuilder[] f(StringBuilder s, StringBuilder[] arr, char prev, int n, int k) {

        if (i == arr.length || i == k)
            return arr;
        if (s.length() == n) {
            arr[i] = new StringBuilder(s);
            i++;
            return arr;
        }

        if (prev != 'a') {
            s.append('a');
            arr = f(s, arr, 'a', n, k);
            s.deleteCharAt(s.length() - 1);
        }
        if (prev != 'b') {
            s.append('b');
            arr = f(s, arr, 'b', n, k);
            s.deleteCharAt(s.length() - 1);
        }
        if (prev != 'c') {
            s.append('c');
            arr = f(s, arr, 'c', n, k);
            s.deleteCharAt(s.length() - 1);
        }
        return arr;
    }

    public String getHappyString(int n, int k) {
        StringBuilder arr[] = new StringBuilder[3 * (int) Math.pow(2, n - 1)];
        if (k > arr.length)
            return "";
        StringBuilder s = new StringBuilder();

        // int[] i = new int[1];
        arr = f(s, arr, '\0', n, k);
        if (arr[k - 1] == null)
            return "";
        // Arrays.sort(arr);
        return arr[k - 1].toString();
    }
}

// class Solution {

//     public int f(StringBuilder s, int i, StringBuilder[] arr, char prev, int n) {

//         if (s.length() == n) {
//             arr[i] = new StringBuilder(s);
//             return i + 1;
//         }

//         if (prev != 'a') {
//             s.append('a');
//             i = f(s, i, arr, 'a', n);
//             s.deleteCharAt(s.length() - 1);
//         }

//         if (prev != 'b') {
//             s.append('b');
//             i = f(s, i, arr, 'b', n);
//             s.deleteCharAt(s.length() - 1);
//         }

//         if (prev != 'c') {
//             s.append('c');
//             i = f(s, i, arr, 'c', n);
//             s.deleteCharAt(s.length() - 1);
//         }

//         return i;
//     }

//     public String getHappyString(int n, int k) {

//         StringBuilder arr[] = new StringBuilder[3 * (int) Math.pow(2, n - 1)];

//         if (k > arr.length)
//             return "";

//         StringBuilder s = new StringBuilder();

//         f(s, 0, arr, '\0', n);

//         Arrays.sort(arr);

//         return arr[k - 1].toString();
//     }
// }