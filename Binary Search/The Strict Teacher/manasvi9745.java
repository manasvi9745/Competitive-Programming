import java.util.*;

public class StrictTeacher {

    static long solveQuery(long n, long[] teachers, long x) {
        int m = teachers.length;

        int idx = Arrays.binarySearch(teachers, x);

        if (idx >= 0) return 0;  // Should not happen as guaranteed distinct

        idx = -idx - 1; // insertion position

        // No teacher on left
        if (idx == 0) {
            return teachers[0] - 1;
        }

        // No teacher on right
        if (idx == m) {
            return n - teachers[m - 1];
        }

        long leftTeacher = teachers[idx - 1];
        long rightTeacher = teachers[idx];

        return Math.min(x - leftTeacher, rightTeacher - x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            long n = sc.nextLong();
            int m = sc.nextInt();
            int q = sc.nextInt();

            long[] teachers = new long[m];
            for (int i = 0; i < m; i++) {
                teachers[i] = sc.nextLong();
            }

            Arrays.sort(teachers);

            for (int i = 0; i < q; i++) {
                long x = sc.nextLong();
                System.out.println(solveQuery(n, teachers, x));
            }
        }

        sc.close();
    }
}