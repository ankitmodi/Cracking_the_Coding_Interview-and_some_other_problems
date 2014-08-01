import java.util.*;
public class Permutation 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first string: ");
		String str1 = input.next();
		
		System.out.println("Enter second string: ");
		String str2 = input.next();
		
		if(isPermutation(str1, str2))
		{
			System.out.println("True: " + str2 + " IS a permutaion of " + str1);
		}
		else
		{
			System.out.println("False: " + str2 + " is NOT a permutaion of " + str1);
		}
		
	}

	public static boolean isPermutation(String str1, String str2) {
		// TODO Auto-generated method stub
		if(str1.length() != str2.length())
		{
			return false;
		}
		boolean result = true;
		int[] array = new int[256];
		
		for(int i=0; i<str1.length(); i++)
		{
			array[str1.charAt(i)] += 1;
			array[str2.charAt(i)] -= 1;
		}
		
		for(int i=0; i< array.length; i++)
		{
			if(array[i] !=0)
			{
				result =  false;
				break;
			}
		}
		
		
		return result;
	}
}
