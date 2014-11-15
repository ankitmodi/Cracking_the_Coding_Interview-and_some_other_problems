
public class PatternMatching1_KMP 
{
	public static void main(String[] args) 
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABAB";
		
		KMPsearch(txt, pat);

	}

	private static void KMPsearch(String txt, String pat) 
	{
		int[] lps = computeLPS(pat);
		printArray(lps);
		int N = txt.length(), M = pat.length();
		char[] text = txt.toCharArray();
		char[] pattern = pat.toCharArray();
		int i=0, j=0;
		while(i<N)
		{
			if(text[i] == pattern[j])
			{
				i++;
				j++;
			}
			if(j==M)
			{
				int tmp = i-j;
				System.out.println("Match found at: " + tmp);
				j = lps[j-1];
			}
			else if(i < N && text[i] != pattern[j])
			{
				if(j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					i++;
				}
			}
		}
		
	}

	private static int[] computeLPS(String pat) 
	{
		int m = pat.length();
		int[] lps = new int[m];
		lps[0] = 0;
		int i = 1, len = 0;
		char[] pattern = pat.toCharArray();
		while(i<m)
		{
			if(pattern[i] == pattern[len])
			{
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
				{
					len = lps[len-1];
				}
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}
	
	private static void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
