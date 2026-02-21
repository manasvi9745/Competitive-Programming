import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);

            out.println(modPow(a, b));
        }

        out.flush();
    }

    static long modPow(long a, long b) {
        if (a == 0 && b == 0) return 1;  // 0^0 = 1

        long result = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {  // if b is odd
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;  // divide by 2
        }

        return result;
    }
}