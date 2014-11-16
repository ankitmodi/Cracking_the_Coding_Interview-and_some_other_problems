/*
 * Given a string s1 remove all occurrences of the string s2 in string s1 and also remove all 
 * occurrences of string s2 after removal of s2 in s1 and so on.. and return the string obtained 
 * after such removals. [5 points]
Example: s1 = "qwewerrty" ; s2 = "wer "
Output: qty 
(On the first removal of wer it becomes qwerty. On removal again now - qty. Nothing to remove now.)

 */
public class Samsung1_RemoveOccurence 
{

	public static void main(String[] args) 
	{
		String s1 = "qwewerrty" ;
		String s2 = "wer";
		System.out.println(remove(s1,s2));

	}

	private static String remove(String s1, String s2) 
	{
		if(s1.isEmpty() || s2.isEmpty())
		{
			return s1;
		}
		int tmp = s1.indexOf(s2);
		int len1 = s1.length();
		int len2 = s2.length();
		while(tmp != -1)
		{
			s1 = s1.substring(0, tmp) + s1.substring(tmp+len2, len1);
			len1 = s1.length();
			tmp = s1.indexOf(s2);
		}
		
		return s1;
	}

}
