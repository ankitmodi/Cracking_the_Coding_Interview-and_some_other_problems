/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

Have you been asked this question in an interview?*/


public class Solution 
{

    //naive solution
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        
        int[][] res = new int[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                res[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matrix[i][j] = res[i][j];
            }
        }
    }
    
    
    //in-space solution
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        
        for(int i=0; i< n/2; i++)
        {
            for(int j=i; j< n-1-i; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
