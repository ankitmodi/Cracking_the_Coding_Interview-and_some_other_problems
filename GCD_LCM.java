import java.util.*;
public class GCD_LCM
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1st no.: ");
		int a = scan.nextInt();
		
		System.out.println("Enter 2nd no.: ");
		int b = scan.nextInt();
		
		System.out.println("GCD is: " + gcd(a,b));
		System.out.println("LCM is: " + lcm(a,b));
	}
	
	
	public static int gcd(int a, int b)
	{
		if(a==b)
		{
			return a;
		}
		
		if(a>b)
			return gcd(a-b,b);
		
		return gcd(a,b-a);
	}
	
	public static int lcm(int a, int b)
	{
		return (a*b)/gcd(a,b);
	}

}
