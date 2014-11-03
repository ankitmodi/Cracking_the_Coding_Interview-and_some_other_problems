/*
 Given a string and a Regular Expression pattern, give the number of the times the pattern 
  occurs in the string. RegEx symbols mean as follows:
. - 2 occurrences of the previous character, 
+ - 4 occurrences of previous character,
* - more than 5 occurrences of the previous character
Sample Input (Plaintext Link)
5
aaaaaannndnnnnnnfffhfhhgjjjwkkkllclc
a.
n+
a*
an.
a.d.
Sample Output (Plaintext Link)
5
3
1
1
0

 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowserStack6_RegEx 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//String input = "aaaaaannndnnnnnnfffhfhhgjjjwkkkllclc";
		
		System.out.println("Enter no. of test cases: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		System.out.println("Enter string: ");
		String input = scan.next();
		
		String[] regex = new String[num];
		
		for(int i=0; i<num; i++)
		{
			System.out.println("Enter regex: ");
			regex[i] = scan.next();
		}
		
		for(int i=0; i<num; i++)
		{
			System.out.println(regexTimes(regex[i], input));
		}	

	}

	private static int regexTimes(String regex, String input) 
	{
		int reglen = regex.length();
		int i=0;
		String newRegex = "";
		while(i<reglen)
		{
			if(regex.charAt(i)=='.')
			{
				String tmp = regex.substring(i-1,i);
				newRegex += tmp;
			}
			else if(regex.charAt(i)=='+')
			{
				String tmp = regex.substring(i-1,i);
				newRegex += tmp+tmp+tmp;
			}
			else if(regex.charAt(i)=='*')
			{
				String tmp = regex.substring(i-1,i);
				newRegex += tmp+tmp+tmp+tmp+tmp+tmp+"*";
			}
			else
			{
				newRegex += regex.substring(i,i+1);
			}
			i++;
		}
		//System.out.println(regex + "  -->  " + newRegex);
		int count =0;
		
		int inputLen = input.length();
		int newRegexLen = newRegex.length();
		for(int k=0; k<inputLen; k++)
		{
			for(int p =k; p<=inputLen; p++)
			{
				if(input.substring(k,p).matches(newRegex))
				{
					count++ ;
				}
			}
		}
		
		return count;
	}

}
