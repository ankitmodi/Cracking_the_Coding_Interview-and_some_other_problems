//Write an algorithm to check if a string has all unique characters
//using additional data structure: O(n)
import java.util.Scanner;
public class Unique_String2 
{
	public static void main(String args[])
	{
		
		System.out.print("Enter String: ");
		Scanner in = new Scanner(System.in);
		String tmp = in.next();
		int len = tmp.length();
		char[] str = tmp.toCharArray();
		boolean[] unique_indicator = new boolean[256];
		boolean result = false;
		
		int j=0;
		
		for(j=0; j<len; j++)
		{
			int val = str[j];
			if(unique_indicator[val])
			{
				result = true;
				break;
			}
			else
			{
				unique_indicator[val] = true;
			}
		}
		
		System.out.println("Are characters unique: "+ !result);
		
	}

}
