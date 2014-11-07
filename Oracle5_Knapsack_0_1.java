/*
 * Given weights and values of n items, put these items in a knapsack of capacity W to get 
 * the maximum total value in the knapsack. In other words, given two integer 
 * arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with
 *  n items respectively. Also given an integer W which represents knapsack capacity, 
 *  find out the maximum value subset of val[] such that sum of the weights of this subset 
 *  is smaller than or equal to W. You cannot break an item, either pick the complete item, 
 *  or don’t pick it (0-1 property).
 */
public class Oracle5_Knapsack_0_1 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] wt = {10, 20, 30};
		int[] val = {60, 100, 120};
		int W = 50;
		System.out.println(Knapsack(wt, val, W, wt.length));
		System.out.println(KnapsackBetter(wt, val, W));

	}
	
	
	
	//using Dynamic Programming
	private static int KnapsackBetter(int[] wt, int[] val, int W) 
	{
		int n = wt.length;
		int[][] K = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++)
		{
			for(int w=0; w<=W; w++)
			{
				if(i==0 || w==0)
				{
					K[i][w] = 0;
				}
				
				else if(wt[i-1] > w)
				{
					K[i][w] = K[i-1][w];
				}
				else
				{
					K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
				}
			}
		}
		
		return K[n][W];
		
		
	}

	
	
	//using only recursion...not optimal
	private static int Knapsack(int[] wt, int[] val, int W, int n) 
	{
		// TODO Auto-generated method stub
		if(n==0 || W==0)
		{
			return 0;
		}
		if(wt[n-1] > W)
		{
			return Knapsack(wt, val, W, n-1);
		}
		
		else
		{
			return Math.max(val[n-1]+Knapsack(wt, val, W-wt[n-1], n-1), Knapsack(wt, val, W, n-1));
		}
		
	}

}
