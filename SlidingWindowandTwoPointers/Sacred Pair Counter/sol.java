import java.util.*;

public class scaredpair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long x = sc.nextLong();
        
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        
        int left = 0;
        int right = n - 1;
        long count = 0;
        
        while(left < right) {
            if(arr[left] + arr[right] <= x) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(count);
    }
}
