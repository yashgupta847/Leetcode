
// Accepted on Leetcode on Jul 05, 2025
// Runtime: 232 ms
// Problem: 2405. Optimal Partition of String

import java.util.*;

class Solution {
    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();
        boolean[] visit = new boolean[s.length()];
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visit[i]) {
                if (!ans.contains(String.valueOf(ch))) {
                    ans.add(String.valueOf(ch));
                    seen.add(String.valueOf(ch));
                    visit[i] = true;
                } else {
                    int j = i + 1;
                    while (j < s.length()) {
                        if (!seen.contains(s.substring(i, j + 1))) {
                            ans.add(s.substring(i, j + 1));
                            seen.add(s.substring(i, j + 1));
                            for (int k = i; k <= j; k++) {
                                visit[k] = true;
                            }
                            i++;
                            break;
                        } else {
                            j++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}