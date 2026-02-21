import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        int left = 0;
        long sum = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}