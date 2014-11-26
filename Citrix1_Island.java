/*
 * Given a boolean 2D matrix, find the number of islands.

This is an variation of the standard problem: 
“Counting number of connected components in a undirected graph”.
 */
public class Citrix1_Island 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[][] mat = {{1, 1, 0, 0, 0},
						{0, 1, 0, 0, 1},
						{1, 0, 0, 1, 1},
						{0, 0, 0, 0, 0},
						{1, 0, 1, 0, 1}};
		System.out.println(connectedComponent(mat));

	}
	
	public static int connectedComponent(int[][] mat)
	{
		int count = 0;
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		
		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length; j++)
			{
				if(mat[i][j]==1 && isSafe(mat, visited, i, j))
				{
					DFS(mat, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void DFS(int[][]mat, boolean[][] visited, int i, int j)
	{
		visited[i][j] = true;
		int[] x = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] y = {1, -1, 0, 1, -1, 0, 1, -1};
		
		for(int k=0; k<x.length; k++)
		{
			if(isSafe(mat, visited, i+x[k], j+y[k]))
			{
				DFS(mat, visited, i+x[k], j+y[k]);
			}
		}
	}
	
	public static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j)
	{
		return i>=0 && j>=0 && i<mat.length && j<mat[0].length && mat[i][j]==1 && !visited[i][j];
	}

}
