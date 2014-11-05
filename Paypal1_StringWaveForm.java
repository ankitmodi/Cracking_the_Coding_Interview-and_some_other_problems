/*
 * Printing a string in wave like pattern. If the current character is greater than(a-z order) 
 * that of previous character then print it above, if it is less than current then print below
 *  and if its equal then in same line.
e.g.
I/P: abcbd
O/P: (these dashes indicates spaces)
---c-d
-b--b
a

 */

import java.util.Arrays;


public class Paypal1_StringWaveForm 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//String input = "ankit";
		//String input = "abcbd";
		String input = "abcbd";
		printWave(input);
		printWaveBetter(input);
		//System.out.println(input);

	}
	
	private static void printWaveBetter(String str)
	{
		int len = str.length();
		int[] arr = new int[len];
		int max = 0, min = 0;
		
		arr[0] = 0;
		for(int i=1; i<len; i++)
		{
			if(str.charAt(i) > str.charAt(i-1))
			{
				arr[i] = arr[i-1]+1;
			}
			else if(str.charAt(i) < str.charAt(i-1))
			{
				arr[i] = arr[i-1]-1;
			}
			else
			{
				arr[i] = arr[i-1];
			}
			
			if(arr[i] > max)
			{
				max = arr[i];
			}
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		
		for(int i=max; i>=min; i--)
		{
			for(int k = 0; k<len; k++)
			{
				if(arr[k] == i)
				{
					System.out.print(str.charAt(k));
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		

	}
	
	private static void printWave(String str)
	{
		int len = str.length();
		String[] arr = new String[2*len+1];
		Arrays.fill(arr, "");
		String curr = str.substring(0,1);
		int level = len;
		arr[len] = curr;
		int i=1;
		
		while(i<len)
		{
			String tmp = str.substring(i,i+1);
			if(tmp.charAt(0) - curr.charAt(0) > 0)
			{
				int diff = arr[level].length() - arr[level+1].length();
				
				while(diff!=0)
				{
					arr[level+1] += " ";
					diff--;
				}
				arr[level+1] += tmp;
				
				curr = tmp;
				level++;
			}
			
			else if(tmp.charAt(0) - curr.charAt(0) < 0)
			{
				int diff = arr[level].length() - arr[level-1].length();
				
				while(diff!=0)
				{
					arr[level-1] += " ";
					diff--;
				}
				arr[level-1] += tmp;
				
				curr = tmp;
				level--;
			}
			
			else
			{
				arr[level] += tmp;
				curr = tmp;
			}
			i++;
			
		}
		
		for(int k=arr.length-1; k>=0; k--)
		{
			if(!arr[k].isEmpty())
			{
				System.out.println(arr[k]);
			}
		}
	}

}
