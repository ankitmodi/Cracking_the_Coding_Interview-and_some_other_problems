//Given a number n, print the sum of digits in n!.(n can be large)


import java.util.*;

public class BrowserStack3_SumDigitNFactorial
{
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scan.nextInt();
		System.out.println("Sum of digits in n factorial = " + SumOfDigitsNFactorial(n));

	}

	private static int SumOfDigitsNFactorial(int n)
	{
		int sum = 0;
		
		int[] digits = new int[5000];
		digits[0] = 1;
		digits[1] = 1;
		int remainder=0;
		
		for(int k=2; k<=n; k++)
		{
			for(int i=1; i<=digits[0]; i++)
			{
				digits[i] = digits[i]*k + remainder;
				remainder = 0;
				if(digits[i] >9)
				{
					remainder = digits[i]/10;
					digits[i] %= 10;
					if(i==digits[0])
					{
						digits[0]++;						
					}
				}
			}
		}
		for(int i=digits[0]; i>0; i--)
		{
			sum += digits[i];
		}
		
		
		return sum;
	}

}
