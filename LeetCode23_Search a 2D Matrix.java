/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.*/


public class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowNum = -1;
        boolean res1 = false, res2 =false;
        
        for(int i =0; i<m; i++)
        {
            if(matrix[i][n-1] >= target)
            {
                rowNum = i;
                res1 = true;
                break;
            }
        }
        if(!res1)
        {
            return res1;
        }
        for(int i=0; i<n; i++)
        {
            if(matrix[rowNum][i]==target)
            {
                res2 = true;
                break;
            }
        }
        return res2;
    }
}
