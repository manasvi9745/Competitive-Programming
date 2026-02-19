import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] prefix = new long[n + 1]; // 1-based prefix

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long val = Long.parseLong(st.nextToken());
            prefix[i] = prefix[i - 1] + val;
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long sum = prefix[r] - prefix[l - 1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
