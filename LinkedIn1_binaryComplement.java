
public class LinkedIn1_binaryComplement 
{

	public static void main(String[] args)
	{
		
		int num = 26;
		
		printBinary(num);
		
		int binComp = getIntComplement(num);
		System.out.println(binComp);
		
		binComp = getIntComplement2(num);
		System.out.println(binComp);
		
		printBinary(binComp);

	}
	
	private static int getIntComplement2(int num) 
	{
		int x = num;
		int count =0;
		while(x!=0)
		{
			x = x>>1;
			count++;
		}
		return (int) Math.pow(2, count) - 1 - num;
	}
	
	private static int getIntComplement(int num) 
	{
		// TODO Auto-generated method stub
		int x = num;
		int count =0;
		while(x!=0)
		{
			x = x>>1;
			count++;
		}
		
		for(int i=0; i<count; i++)
		{
			num = num ^ (1<<i);
		}
		return num;
	}

	
	

	public static void printBinary(int num)
	{
		int x = num;
		String res = "";
		while(x!=0)
		{
			res = String.valueOf(x%2)+res;
			x /= 2;
		}
		System.out.println(res);
	}

}
