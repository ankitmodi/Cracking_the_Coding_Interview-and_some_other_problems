/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. */


public class Solution 
{
    public int removeElement(int[] A, int elem) 
    {
        int i=0;
        int n = A.length-1;
        while(i<=n)
        {
            if(A[i] == elem)
            {
                swap(A, i, n);
                n--;
            }
            else
            {
                i++;
            }
        }
        return i;
    }
    
    public void swap(int[] A, int x, int y)
    {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
