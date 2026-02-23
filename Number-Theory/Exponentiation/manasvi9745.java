import java.io.*;
import java.util.*;

public class Main {
    static final long MODULO = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int queries = Integer.parseInt(reader.readLine());

        while (queries-- > 0) {
            String[] values = reader.readLine().split(" ");
            long base = Long.parseLong(values[0]);
            long exponent = Long.parseLong(values[1]);

            writer.println(powerModulo(base, exponent));
        }

        writer.flush();
    }

    static long powerModulo(long base, long exponent) {
        if (base == 0 && exponent == 0) return 1;  // 0^0 = 1

        long answer = 1;
        base %= MODULO;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {  // if exponent is odd
                answer = (answer * base) % MODULO;
            }
            base = (base * base) % MODULO;
            exponent >>= 1;  // divide exponent by 2
        }

        return answer;
    }
}