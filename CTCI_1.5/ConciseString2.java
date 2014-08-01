//without string concatenation

import java.util.Scanner;

public class ConciseString2 
{
	public static void main(String args[])
	{
		System.out.print("Input your string: ");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		int size = ConciseStringSize(str);
		//System.out.println("Size of concised string is: " + size);
		
		if(size < str.length())
		{
			System.out.println("Concised string is: " + Concise(str, size));
		}
		else
		{
			System.out.println("Concised string is: " + str);
		}
		
		
		
	}
	
	
	
	public static int ConciseStringSize(String str)
	{
		
		int i =0, j=0;
		int strlen = str.length();
		int count;
		int size=0;
		
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
			
			size = size + 1 + Integer.toString(count).length() ;
			
			i += count;
		}
		return size;
		
	}
	
	
	
	public static String Concise(String str, int size) 
	{
		// TODO Auto-generated method stub
		char[] array = new char[size];
		int count=0, i=0, j=0;
		int array_index = 0;
		
		while(i < str.length())
		{
			char tmp_char = str.charAt(i);
			count =0;
			
			for(j=i; j<str.length(); j++)
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
			array_index = setchar(array, array_index, tmp_char, count);
			i += count;
		}
		
		String result = new String(array);
		return result;
	}

	
	
	public static int setchar(char[] array, int array_index, char tmp_char, int count) 
	{
		// TODO Auto-generated method stub
		array[array_index] = tmp_char;
		array_index++ ;
		
		char[] countString = Integer.toString(count).toCharArray();
		for(int i=0; i<countString.length; i++)
		{
			array[array_index] = countString[i];
			array_index++ ;
			
		}
		return array_index;
	}

	
}
