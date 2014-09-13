/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. */


public class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int m = matrix.length;
        List res = new ArrayList<Integer>();
        if(m==0)
        {
            return res;
        }
        int n = matrix[0].length;
        
        
        
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
                res.add(matrix[i][j]);
                j++;
                steps--;
            }
            j--;
            i++;
            right++;
            
            //going down
            steps = m - right - left;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                res.add(matrix[i][j]);
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
                res.add(matrix[i][j]);
                j--;
                steps--;
            }
            j++;
            i--;
            left++;
            
            //going up
            steps = m - left - right;
            if(steps==0)
            {
                break;
            }
            while(steps>0)
            {
                res.add(matrix[i][j]);
                i--;
                steps--;
            }
            i++;
            j++;
            up++;
        }
        
        return res;
    }
}
