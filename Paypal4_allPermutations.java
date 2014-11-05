//Print all unique permutations of a string
import java.util.*;
public class Paypal4_allPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String input = "aabc";
		//int len = input.length();
		char[] str = input.toCharArray();
		HashMap hash = new HashMap();
		permute(str, 0, hash);

	}

	private static void permute(char[] str, int i, HashMap hash) 
	{
		if(i==str.length)
		{
			String tmp = new String(str);
			if(!hash.containsKey(tmp))
			{
				System.out.println(tmp);
				hash.put(tmp, 0);
			}
		}
		
		for(int j=i; j<str.length; j++)
		{
			swap(str, i, j);
			permute(str, i+1, hash);
			swap(str, i ,j);
		}
		
	}

	private static void swap(char[] str, int i, int j) 
	{
		// TODO Auto-generated method stub
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
		
	}

}
