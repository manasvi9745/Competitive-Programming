import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            long n = fs.nextLong();
            int m = fs.nextInt();
            int q = fs.nextInt();

            long[] teachers = new long[m];
            for (int i = 0; i < m; i++)
                teachers[i] = fs.nextLong();

            Arrays.sort(teachers);

            while (q-- > 0) {
                long david = fs.nextLong();

                int pos = Arrays.binarySearch(teachers, david);

                if (pos >= 0) {
                    sb.append(0).append("\n");
                    continue;
                }

                pos = -pos - 1;

                if (pos == 0) {
                    // left of all teachers
                    sb.append(teachers[0] - 1).append("\n");
                } else if (pos == m) {
                    // right of all teachers
                    sb.append(n - teachers[m - 1]).append("\n");
                } else {
                    long left = teachers[pos - 1];
                    long right = teachers[pos];
                    sb.append((right - left) / 2).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    // Fast I/O
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}