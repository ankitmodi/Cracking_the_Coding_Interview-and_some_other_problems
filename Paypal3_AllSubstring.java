/*
 * Print all substrings of a given string.(Remove possible duplicates although it wasn’t explicitly mentioned). 
for example input-abc
output-
a
ab
abc
b
bc
c 
 */
import java.util.*;
public class Paypal3_AllSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String input = "aaabbc";
		allSubstring(input);

	}

	private static void allSubstring(String input) 
	{
		HashMap hash = new HashMap();
		
		int len = input.length();
		
		for(int i=0; i<len; i++)
		{
			for(int j=i+1; j<len+1; j++)
			{
				String temp = input.substring(i, j);
				if(!hash.containsKey(temp))
				{
					System.out.println(temp);
					hash.put(temp, 0);
				}
			}
		}
		
	}

}
