/*
 * Maximum number of cake pieces that can be generated from a huge circular cake with 
 * N vertical cuts.
 */
public class Oracle1_CircleCutting 
{

	public static void main(String[] args) 
	{
		
		long n = 1000000000;
		System.out.println(maxCut(n));
	}

	private static long maxCut(long n) 
	{
		long res = ( n + (n*n) + 2)/2;
		return res;
	}

}
