/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. */
public class Solution 
{
    public int maxSubArray(int[] A) 
    {
        int sum=A[0], maxSum = A[0];
        if(A.length ==1)
        {
            return A[0];
        }
        for(int i=1; i< A.length; i++)
        {
            if(A[i] > A[i] + sum)
            {
                sum = A[i];
            }
            else
            {
                sum += A[i];
            }
            if(sum > maxSum)
            {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
