/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/


public class Solution 
{
    public int[][] generateMatrix(int n) 
    {
        int[][] matrix = new int[n][n];
        if(n==0)
        {
            return matrix;
        }
        int num = 1; 
        
        int right=0, down=0, left=0, up=0;
        int steps = n, i=0, j=0;
        while(true)
        {
            //going right
            steps = n - up - down;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                matrix[i][j] = num;
                num++;
                j++;
                steps--;
            }
            j--;
            i++;
            right++;
            
            //going down
            steps = n - right - left;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                matrix[i][j] = num;
                num++;
                i++;
                steps--;
            }
            i--;
            j--;
            down++;
            
            //going left
            steps = n - up - down;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                matrix[i][j] = num;
                num++;
                j--;
                steps--;
            }
            j++;
            i--;
            left++;
            
            //going up
            steps = n - left - right;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                matrix[i][j] = num;
                num++;
                i--;
                steps--;
            }
            i++;
            j++;
            up++;
        }
        
        return matrix;
    }
}
