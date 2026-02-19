package DP.Q1;
import java.util.*;
class tpundir007_artFibonacci
{
    public int fib(int n) 
    { 
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
    public int  helper(int[] dp,int n)
    {
        if(n==0) return 0;
        if(n==1) return 1;
        
        if(dp[n]!=-1) return dp[n];
        return dp[n]=helper(dp,n-1)+helper(dp,n-2);
    }
    public static void main(String[] args) {
        Scanner so=new Scanner(System.in);
        int x=so.nextInt();
        tpundir007_artFibonacci obj=new tpundir007_artFibonacci();
        System.out.println(obj.fib(x)); 
        so.close();
    }
}