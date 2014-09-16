/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/


public class Solution 
{
    public int search(int[] A, int target) 
    {
        int start = 0, end = A.length-1;
        
        while(start <= end)
        {
            int mid = (start+end) /2;
            if(A[mid]==target)
            {
                return mid;
            }
            //if it is the strictly increasing half
            if(A[start]<=A[mid])
            {
                //if target is in this half
                if(target>=A[start] && target<=A[mid])
                {
                    end = mid-1;
                }
                else
                {
                    start =mid+1;
                }
            }
            //it is not the strictly increasing half
            else
            {
                //if target is in the other half
                if(target>=A[mid] && target<=A[end])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
                
            }
        }
        return -1;
    }
}
