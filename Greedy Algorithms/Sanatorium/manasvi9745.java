import java.util.*;

public class SanatoriumOptimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long b = sc.nextLong();
        long d = sc.nextLong();
        long s = sc.nextLong();

        long max = Math.max(b, Math.max(d, s));
        long min = Math.min(b, Math.min(d, s));

        long result = Math.max(0, max - min - 1);

        System.out.println(result);
    }
}