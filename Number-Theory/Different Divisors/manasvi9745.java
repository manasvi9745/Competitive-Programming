import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long d = sc.nextLong();
            System.out.println(solve(d));
        }
    }

    static long solve(long d) {
        long p = nextPrime(d + 1);
        long q = nextPrime(p + d);

        return p * q;
    }

    static long nextPrime(long start) {
        while (!isPrime(start)) {
            start++;
        }
        return start;
    }

    static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}