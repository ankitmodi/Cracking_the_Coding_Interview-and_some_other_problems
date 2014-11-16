/*
 * Given a number n, find how many substrings of it is divisible by 11. 
 * E.g: 1331 -> (1,3,3,1,13,33,31,133,331,1331) are the substrings.
 *  33 and 1331 are divisible. So return 2.
 */
public class Samsung5_substringDivisible {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n = 1331;
		System.out.println(countDivisibleSubstring(n));

	}

	private static int countDivisibleSubstring(int n) 
	{
		int count =0;
		String tmp = String.valueOf(n);
		int len = tmp.length();
		for(int i=0; i<len; i++)
		{
			for(int j=i+1; j<=len; j++)
			{
				int num = Integer.parseInt(tmp.substring(i,j));
				if(num!=0 && num%11==0)
				{
					count++;
				}
			}
		}
		return count;
	}

}
