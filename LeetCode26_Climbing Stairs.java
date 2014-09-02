/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */

public class Solution 
{
    public int climbStairs(int n) 
    {
        int[] myArr = new int[n];
        Arrays.fill(myArr, -1);
        
        
        return fib(myArr, n);
        
    }
    
    public int fib(int[] myArr, int n)
    {
        if(myArr[n-1]==-1)
        {
            if(n-1 == 0 || n-1 == 1)
            {
                myArr[n-1] = n;
            }
            else
            {
                myArr[n-1] = fib(myArr, n-1) + fib(myArr, n-2);
            }
        }
        return myArr[n-1];
    }
    
    
    
}
