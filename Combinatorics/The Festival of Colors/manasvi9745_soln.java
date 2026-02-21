import java.util.*;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(n, m, k));
    }

    static long solve(int n, int m, int k) {
        if (n == 0) return 0;

        long[][] dp = new long[n + 1][k + 1];

        // Base case
        dp[1][1] = m;

        for (int i = 2; i <= n; i++) {

            long totalPrev = 0;
            for (int j = 1; j <= k; j++) {
                totalPrev = (totalPrev + dp[i - 1][j]) % MOD;
            }

            // Case 1: Change color → streak becomes 1
            dp[i][1] = (totalPrev * (m - 1)) % MOD;

            // Case 2: Continue same color
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1];
            }
        }

        long answer = 0;
        for (int j = 1; j <= k; j++) {
            answer = (answer + dp[n][j]) % MOD;
        }

        return answer;
    }
}