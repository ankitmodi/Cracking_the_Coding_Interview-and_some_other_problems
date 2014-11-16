import java.util.Arrays;

/*
 * You're given an array of integers. Return the largest number
 *  you can make using all the digits in the array. e.g: a=[23,45,67], return 765432. 
 */
public class Samsung4_LargeNum 
{

	public static void main(String[] args) 
	{
		int[] a = {23, 45, 67};
		System.out.println(largeNum(a));
	}

	private static int largeNum(int[] a) 
	{
		String res = "";
		for(int num: a)
		{
			res += String.valueOf(num);
		}
		char[] tmp = res.toCharArray();
		
		Arrays.sort(tmp);
		String s = new String(tmp);
		String rev = new StringBuffer(s).reverse().toString();
		
		return Integer.parseInt(rev);
	}

}
