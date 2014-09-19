/* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) */


public class Solution 
{
    public int jump(int[] A) 
    {
        if(A.length<=1)
        {
            return 0;
        }
        int i = 0, count =0, m =0;
        while(i<A.length)
        {
            m = Math.max(m, i+A[i]);
            if(m>0)
            {
                count++;
            }
            if(m>=A.length-1)
            {
                return count;
            }
            int tmp = 0;
            for(int j=i+1; j<=m; j++)
            {
                if(j+A[j] > tmp)
                {
                    tmp = j+A[j];
                    i = j;
                }
            }
        }
        return count;
    }
}
