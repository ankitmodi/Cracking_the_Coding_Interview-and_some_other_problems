/*Implement int sqrt(int x).

Compute and return the square root of x.*/


public class Solution 
{
    public int sqrt(int x) 
    {
        if(x==0|x==1)
        {
            return x;
        }
        double start =0, end = x;
        double mid = (start+end)/2;
        while(Math.abs(start-end) >= 0.000001)
        {
            if(mid*mid > x)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
            mid = (start+end)/2.0;
        }
        int res = (int) (mid + 0.000001);
        
        return res;
    }
}
