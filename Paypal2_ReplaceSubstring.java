/*
 * Replace the given substring with some other substring in a string.
I/P: SUNDAY, replace SU with MO
MONDAY
 */
import java.util.*;


public class Paypal2_ReplaceSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String input = "sundaysundaysu";
		String s1 = "su";
		String s2 = "mo";
		
		//System.out.println(input.indexOf("sunde"));

		String output = replaceSubstring(input, s1, s2);
		System.out.println(output);

	}

	private static String replaceSubstring(String input, String s1, String s2) 
	{
		String res ="";
		if(input.isEmpty())
		{
			return res;
		}
		
		List<Integer> indexes = new ArrayList<Integer>();
		
		int i= input.indexOf(s1);
		while(i!=-1)
		{
			indexes.add(i);
			i = input.indexOf(s1, i+1);		
		}
		
		int size = indexes.size();
		
		int len1 = s1.length();
		
		int start=0, end = indexes.get(0);
		res = input.substring(start,end) + s2;
		for(int k=1; k<size; k++)
		{
			start = end+len1;
			end = indexes.get(k);
			res += input.substring(start,end) + s2;
		}
		start = end+len1;
		end = input.length();
		res+= input.substring(start,end);
		
		return res;
	}

}
