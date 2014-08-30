/*  Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? */

public class Solution 
{
    public int singleNumber(int[] A) 
    {
        int lonelyNumber = 0;
        for(int i=0; i< 32; i++)
        {
            int count = 0;
            for(int j=0; j<A.length; j++)
            {
                if((A[j] & 1<<i) != 0)
                {
                    count ++ ;
                    
                }
            }
            if(count%3 != 0)
            {
                lonelyNumber |= 1 << i ;
            }
        }
        return lonelyNumber;
        
    }
}
