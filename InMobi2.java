/*Given an array of integers, you need to check if its an arithmetic progression, 
 * geometric progression or fibonacci series. You then need to return the next number
 *  in the series or -999 if the given numbers does not follow any of the above series.
 *  The fibonacci series need not start with 0. A valid fibonacci series could be 8,9,17*/


public class InMobi2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//int[] arr = {5, 8, 11, 14, 17, 20};
		//int[] arr = {5, 10, 20, 40, 80, 160};
		//int[] arr = {5, 8, 13, 21, 34, 55};
		int[] arr = {64, 32, 16, 8, 4};

		
		int result = 0;
		
		if(arr.length<=1)
			System.out.println("Nothing" + -999);
		
		if(inAP(arr))
		{
			result = arr[arr.length-1] + arr[1] - arr[0];
			System.out.println("AP: " + result); 
		}
			
		else if(inGP(arr))
		{
			double res = arr[arr.length-1] * ((double)arr[1] / arr[0]);
			System.out.println("GP: " + (int)res); 
		}
		
		else if(inFib(arr))
		{
			result = arr[arr.length-1] + arr[arr.length-2];
			System.out.println("Fib: " + result); 
		}
		else
		{
			System.out.println("Nothing: " + -999);
		}

	}

	

	private static boolean inGP(int[] arr) {
		// TODO Auto-generated method stub
		double r = (double)arr[1] / arr[0];
		for(int i=2; i<arr.length; i++)
		{
			if((double)arr[i]/arr[i-1] != r)
				return false;
		}
		return true;
	}

	private static boolean inAP(int[] arr) 
	{
		// TODO Auto-generated method stub
		int d = arr[1] - arr[0];
		for(int i=2; i<arr.length; i++)
		{
			if(arr[i] - arr[i-1] != d)
				return false;
		}
		return true;
	}
	
	private static boolean inFib(int[] arr) 
	{
		// TODO Auto-generated method stub
		int a0 = nthFib(arr[0]);
		int a1 = nthFib(arr[1]);
		
		if((a0==-1 || a1==-1) || a1-a0 != 1)
		{
			return false;
		}
		
		for(int i=2; i<arr.length; i++)
		{
			if(arr[i] != arr[i-1] +arr[i-2])
				return false;
		}
		
		return true;
	}
	
	private static int nthFib(int x) 
	{
		// TODO Auto-generated method stub
		int i= 0;
		while(fib(i) < x)
		{
			i++;
		}
		if(fib(i)==x)
		{
			return i;
		}
		
		return -1;
	}



	private static int fib(int n)
	{
		int[] a = new int[n+1];
		if(n<1)
			return n;
		a[0] = 0;
		a[1] = 1;
		for(int i=2; i<a.length; i++)
		{
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}

}
