import java.io.*;
import java.util.*;

public class Main {

    static int[][] st;
    static int[] log;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stt.nextToken());
        int q = Integer.parseInt(stt.nextToken());

        int[] arr = new int[n];
        stt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
        }

        buildSparseTable(arr);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            stt = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(stt.nextToken()) - 1;
            int r = Integer.parseInt(stt.nextToken()) - 1;
            sb.append(query(l, r)).append('\n');
        }

        System.out.print(sb);
    }

    static void buildSparseTable(int[] arr) {
        // Precompute logs
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;
        st = new int[n][K];

        // Initialize
        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i];
        }

        // Build
        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.min(
                        st[i][j - 1],
                        st[i + (1 << (j - 1))][j - 1]
                );
            }
        }
    }

    static int query(int L, int R) {
        int length = R - L + 1;
        int k = log[length];
        return Math.min(
                st[L][k],
                st[R - (1 << k) + 1][k]
        );
    }
}
