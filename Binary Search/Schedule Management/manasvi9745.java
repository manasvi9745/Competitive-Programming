import java.io.*;
import java.util.*;

public class Main {

    static boolean canFinish(int[] count, int n, int m, int T) {
        long extraCapacity = 0;
        long remainingTasks = 0;

        for (int i = 1; i <= n; i++) {

            if (count[i] > T) {
                // tasks that this worker can't finish in T time
                remainingTasks += count[i] - T;
            } else {
                // extra time available
                extraCapacity += (T - count[i]) / 2;
            }
        }

        return extraCapacity >= remainingTasks;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] count = new int[n + 1];

            for (int i = 0; i < m; i++) {
                int worker = sc.nextInt();
                count[worker]++;
            }

            int low = 0;
            int high = 2 * m;
            int answer = high;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (canFinish(count, n, m, mid)) {
                    answer = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}