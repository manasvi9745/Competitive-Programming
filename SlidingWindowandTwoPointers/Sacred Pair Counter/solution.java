import java.util.*;

class Solution {

    public long countPairs(long[] nums, long x) 
    {
        if(nums.length <= 1) return 0;

        int left = 0;
        long count = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            while(left < right && nums[left] + nums[right] > x)
                right--;

            count += right - left;
            left++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        long[] nums = new long[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextLong();

        Solution obj = new Solution();
        System.out.println(obj.countPairs(nums, x));
    }
}
