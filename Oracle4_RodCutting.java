/*
 * Given a rod of length n inches and an array of prices that contains prices of all piece
 * s of size smaller than n. Determine the maximum value obtainable by cutting up the rod 
 * and selling the pieces. For example, if length of the rod is 8 and the values of different 
 * pieces are given as following, then the maximum obtainable value is 22 (by cutting in two
 *  pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in 
eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

 */
public class Oracle4_RodCutting 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//int[] length = {1,2, 3, 4, 5, 6, 7, 8};
		//int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] length = {1,2, 3, 4, 5, 6, 7, 8};
		int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxPrice(length, price));
	}

	private static int maxPrice(int[] length, int[] price) 
	{
		int[] val = new int[length.length+1];
		val[0] = 0;
		
		for(int i=1; i<val.length; i++)
		{
			int maxval = Integer.MIN_VALUE;
			for(int j=0; j<i; j++)
			{
				maxval = Math.max(maxval, price[j] + val[i-j-1]);
			}
			val[i] = maxval;
		}
		return val[val.length-1];
	}

}
