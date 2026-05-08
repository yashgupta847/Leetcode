import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int[] spf = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                if ((long) i * i <= max) {
                    for (int j = i * i; j <= max; j += i) {

                        if (spf[j] == 0) {
                            spf[j] = i;
                        }
                    }
                }
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = spf[x];
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (x % p == 0) {
                    x /= p;
                }
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) {
                    return steps;
                }
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }
                int val = nums[i];
                if (val > 1 && spf[val] == val) {
                    List<Integer> next = map.get(val);
                    if (next != null) {
                        for (int idx : next) {
                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }
                        map.remove(val);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}