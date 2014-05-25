//Write an algorithm to check if a string has all unique characters
import java.util.Scanner;
public class Unique_String 
{
	public static void main(String args[])
	{
		
		System.out.print("Enter String: ");
		Scanner in = new Scanner(System.in);
		String tmp = in.next();
		int len = tmp.length();
		char[] str = tmp.toCharArray();
		int result = 0;
		int i=0, j=0;
		
		for(i=0; i< len; i++)
		{
			for(j=i+1; j<len; j++)
			{
				if(str[i] == str[j])
				{
					result = 1;
					break;
				}
			}
			if(result==1)
			{
				break;
			}
		}
		
		if(result ==0)
		{
			System.out.println(tmp + " : Each character UNIQUE");
		}
		else
		{
			System.out.println("First repeated character: " + str[i]);
		}
		
	}

}
