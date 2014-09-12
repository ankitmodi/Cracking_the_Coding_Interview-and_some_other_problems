/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/


public class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        
        
        int[][] cost = new int[m][n];
        
        
        cost[0][0] = grid[0][0];
        
        for(int i=1; i<m; i++)
        {
            cost[i][0] = grid[i][0] + cost[i-1][0];
        }
        
        for(int i=1; i<n; i++)
        {
            cost[0][i] = grid[0][i] + cost[0][i-1];
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                cost[i][j] = grid[i][j] + min(cost[i-1][j], cost[i][j-1]);
            }
        }
        
        
        return cost[m-1][n-1];
    }
    
    
    public int min(int a, int b)
    {
        if(a<b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
}
