/*
 * Given two strings check whether one is psuedo-anagram of other.
conditions:-
(i)only letters need to be considered.
e.g. abcd and bc-"ad? are psuedo-anagrams.
(ii)case-insensitive.
e.g. abCd and BCaD are psuedo-anagrams.
(iii)repetition of characters is allowed.
e.g. abcd and bccaaad are psuedo-anagrams.
 */
public class Citrix3_pseudoAnagram 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String str1 = "abCd", str2 = "Bc-*AD";
		String s1 = convert(str1);
		String s2 = convert(str2);
		boolean res = checkPseudoAnagram(s1, s2);
		System.out.println(res);

	}

	private static boolean checkPseudoAnagram(String s1, String s2) 
	{
		boolean[] count = new boolean[26];
		int len1 = s1.length();
		int len2 = s2.length();
		for(int i=0; i<len1; i++)
		{
			if(!count[s1.charAt(i) - 'a'])
			{
				count[s1.charAt(i) - 'a'] = true;
			}
		}
		for(int i=0; i<len2; i++)
		{
			if(!count[s2.charAt(i) - 'a'])
			{
				return false;
			}
		}
		
		return true;
	}

	private static String convert(String str) 
	{
		String tmp = str.toLowerCase(), res="";
		char[] arr = tmp.toCharArray(); 
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]>=97 && arr[i]<=122)
			{
				res += arr[i];
			}
		}
		//System.out.println(res);
		return res;
		
	}

}
