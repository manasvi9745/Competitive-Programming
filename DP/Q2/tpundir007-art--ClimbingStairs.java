package DP.Q2;
import java.util.*;
class Solution 
{
    public int climbStairs(int n) 
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help(dp,n);

    }
    public int help(int[]dp,int n)
    {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        if(n==2)
        return 2;
        if (dp[n]!=-1) return dp[n];
        return dp[n]=help(dp,n-1)+help(dp,n-2);

    }
    public static void main(String[] args) {
        Scanner so=new Scanner(System.in);
        int x=so.nextInt();
        Solution obj=new Solution();
        System.out.println(obj.climbStairs(x));
        so.close();
    }
}