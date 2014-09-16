/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/


public class Solution 
{
    public boolean search(int[] A, int target) 
    {
        int start = 0, end = A.length-1;
        
        while(start <= end)
        {
            int mid = (start+end) /2;
            if(A[mid]==target)
            {
                return true;
            }
            //if it is the strictly increasing half
            if(A[start]<A[mid])
            {
                //if target is in this half
                if(target>=A[start] && target<A[mid])
                {
                    end = mid-1;
                }
                else
                {
                    start =mid+1;
                }
            }
            //it is not the strictly increasing half
            else if(A[start]>A[mid])
            {
                //if target is in the other half
                if(target>A[mid] && target<=A[end])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
                
            }
            
            else
            {
                start++;
            }
        }
        return false;
    }
}
