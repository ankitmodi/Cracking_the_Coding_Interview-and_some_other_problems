/*
 * Tell the indian expansion for a given number.
e.g., if the number is 999999999 then answer will be ninety nine crores ninety nine lakhs 
ninety nine thousand nine hundred and ninety nine only.
 */
public class Citrix2_NumToWords 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(convertNum(1001));
	}
	
	private static String convertNum(int num)
	{
		if(num==0)
		{
			return "zero";
		}
		int x = num, count = 0, rem;
		
		String res = "";
		while(x!=0)
		{
			switch(count)
			{
			case 0:
				rem = x%100;
				x /= 100;
				res = convertTwoDigitNo(rem);
				break;
			case 1:
				rem = x%10;
				x /= 10;
				if(rem!=0)
					{res = convertTwoDigitNo(rem) + " hundred " + res;}
				break;
			case 2:
				rem = x%100;
				x /= 100;
				if(rem!=0)
				{res = convertTwoDigitNo(rem) + " thousand " + res;}
				break;
			case 3:
				rem = x%100;
				x /= 100;
				if(rem!=0)
				{res = convertTwoDigitNo(rem) + " lakh " + res;}
				break;
			case 4:
				rem = x%100;
				x /= 100;
				if(rem!=0)
				{res = convertTwoDigitNo(rem) + " crore " + res;}
				break;
			}
			count++;
		}
		return res;
	}

	private static String convertTwoDigitNo(int num) {
		// TODO Auto-generated method stub
		String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
						"ten", "elven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
						"seventeen", "eighteen", "ninteen"};
		if(num < 20)
		{
			return ones[num];
		}
		
		String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		return tens[num/10 - 2] + " " + ones[num%10];		
	}

}
