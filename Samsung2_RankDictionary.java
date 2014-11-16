import java.util.Arrays;

/*
 * Given a word with unique lower-case characters, return its rank in a dictionary 
 * that consists only of words that are anagrams of the given word.
Eg: "take" : 6 words start with 'a', 6 with 'e', 6 with 'k', 1 with 'tae', and 
finally "take", so its rank is 6 + 6 + 6 + 1 + 1 = 20.
 */
public class Samsung2_RankDictionary 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String s1 = "take" ;
		
		System.out.println(rank(s1));
		//System.out.println(fact(1));

	}

	private static int rank(String s1) 
	{
		int len = s1.length();
		char[] orig = s1.toCharArray();
		//char[] sorted = s1.toCharArray();
		//Arrays.sort(sorted);
		//String sorted_s1 = new String(sorted);
		
		//print(orig);
		//print(sorted);
		int rank =1;
		for(int i=0; i<orig.length;i++)
		{
			rank += countLowerRight(orig, i)*fact(len-1-i);
		}
		return rank;
	}
	private static int countLowerRight(char[] orig, int x)
	{
		int count =0;
		for(int i=x+1; i<orig.length;i++)
		{
			if(orig[i] < orig[x])
			{
				count++;
			}
		}
		return count;
	}
	
	private static int fact(int x)
	{
		if(x==0 | x==1)
		{
			return 1;
		}
		int[] arr = new int[x+1];
		arr[0] = 1; arr[1] = 1;
		for(int i=2; i<=x; i++)
		{
			arr[i] = arr[i-1]*i;
		}
		return arr[x];
	}

	private static void print(char[] orig) 
	{
		for(int i=0; i<orig.length; i++)
		{
			System.out.print(orig[i]);
		}
		System.out.println();
		
	}

}
