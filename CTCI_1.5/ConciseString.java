//Not a very good method as string concatenation is costly

import java.util.*;

public class ConciseString 
{
	public static void main(String args[])
	{
		System.out.print("Input your string: ");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		System.out.println("Concised string is: " + Concise(str));
		
	}
	
	public static String Concise(String str)
	{
		String result ="";
		int i =0, j=0;
		int strlen = str.length();
		int count;
		
		while(i < strlen)
		{
			char tmp_char = str.charAt(i);
			count =0;
			
			for(j=i; j<strlen; j++)
			{
				if(str.charAt(j) == tmp_char)
				{
					count += 1;
				}
				else
				{
					break;
				}
			}
			result = result + tmp_char + Integer.toString(count);
			i += count;
		}
		
		if(result.length() < strlen)
		{
			return result;
		}
		
		else
		{
			return str;
		}
		
	}
}
