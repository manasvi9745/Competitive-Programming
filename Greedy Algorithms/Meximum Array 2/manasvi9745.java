import java.util.*;

public class MeximumArrayOptimal {

    static boolean checkMex(int[] a, int l, int r, int k) {
        boolean[] seen = new boolean[k + 1];
        for (int i = l; i <= r; i++) {
            if (a[i] <= k)
                seen[a[i]] = true;
        }

        for (int i = 0; i < k; i++)
            if (!seen[i]) return false;

        return !seen[k];
    }

    static boolean checkMin(int[] a, int l, int r, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++)
            min = Math.min(min, a[i]);
        return min == k;
    }

    public static void solve(int n, int k, int q, int[][] queries) {

        int[] a = new int[n];

        // Step 1: fill everything with k
        Arrays.fill(a, k);

        // Step 2: process MEX queries
        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 2) {
                int l = queries[i][1] - 1;
                int r = queries[i][2] - 1;

                int idx = l;
                for (int val = 0; val < k && idx <= r; val++) {
                    a[idx++] = val;
                }
            }
        }

        // Print
        for (int val : a)
            System.out.print(val + " ");
        System.out.println();
    }
}