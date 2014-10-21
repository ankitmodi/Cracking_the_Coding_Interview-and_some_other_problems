/*4. Given a number, get all possible substrings using the digits of this number and if the product of 
digits in one subset is same with the another, then return false, else return true.
e.g. 345={3,4,34,45,35,345}
products are{3,4,5,12,20,15,60} hence true
3426={3,4,2,6,34,42,26,....}
product ={3,4,2,6,12,8,12,..} hence false. (products of 34 and 26 are same)
*/

import java.util.*;
public class Epic3_Number_Substring 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number: ");
		String num = scan.next();
		
		LinkedList list = genSubstring(num);
		int size = list.size();
		for(int i=0; i<size; i++)
		{
			System.out.print(" "+ list.get(i));
		}
		System.out.print("\n");
		
		int[] arr = new int[size];
		for(int i=0; i<size; i++)
		{
			String t = (String)list.get(i);
			arr[i] = productDig(t);
		}
		
		for(int i: arr)
		{
			System.out.print(" "+ i);
		}
		System.out.print("\n");
		
		
		boolean result = true;
		
		HashMap hash = new HashMap();
		for(int i: arr)
		{
			if(hash.containsKey(i))
			{
				result = false;
				break;
			}
			else
			{
				hash.put(i, 1);
			}
		}
		
		System.out.println("result is:" + result);

	}
	
	
	public static int productDig(String str)
	{
		int num = Integer.parseInt(str);
		int prod=1;
		while(num!=0)
		{
			prod *= (num%10);
			num /=10;	
		}
		return prod;
	}
	
	
	public static LinkedList genSubstring(String str)
	{
		LinkedList res = new LinkedList();
		
		int numDig = str.length();
		
		for(int i=0; i<numDig; i++)
		{
			for(int j=i; j<numDig; j++)
			{
				res.add(str.substring(i,j+1));
			}
		}
		
		
		return res;
	}
	
	
}
