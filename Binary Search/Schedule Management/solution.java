import java.util.*;

class Solution {

    public int minimumTime(int n, int[] tasks) {
        int m = tasks.length;

        int[] cnt = new int[n + 1];
        for (int x : tasks)
            cnt[x]++;

        long left = 0, right = 2L * m;
        long ans = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canFinish(mid, cnt, n)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean canFinish(long T, int[] cnt, int n) {
        long overflow = 0;
        long help = 0;

        for (int i = 1; i <= n; i++) {
            if (cnt[i] > T)
                overflow += cnt[i] - T;
            else
                help += (T - cnt[i]) / 2;
        }

        return help >= overflow;
    }

}
