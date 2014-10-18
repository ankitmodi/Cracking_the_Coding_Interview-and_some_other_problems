 /*Given an array of integers and a number, count the total number
 of subsets of the array with sum equal to the number*/

import java.util.*;
public class InMobi1
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = arr.length;
		System.out.println("there is a subset?: " + isSubset(arr, n, sum));
		System.out.println("no. of subsets: " + numberSubset(arr, n, sum));
		
		LinkedList l = new LinkedList();
		printSubset(arr, n, sum, "", l);
		int size = l.size();
		System.out.println("subsets are:");

		
		for(int i=0; i < size; i++)
		{
			System.out.println(l.get(i));

		}

	}

	private static boolean isSubset(int[] arr, int n, int sum) 
	{
		// TODO Auto-generated method stub
		if(n==0 && sum!=0)
			return false;
		if(sum==0)
		{
			return true;
		}
		return isSubset(arr, n-1, sum) || isSubset(arr, n-1, sum-arr[n-1]);
	}
	
	private static int numberSubset(int[] arr, int n, int sum) 
	{
		// TODO Auto-generated method stub
		if(n==0 && sum!=0)
			return 0;
		if(sum==0)
			return 1;
		
		return numberSubset(arr, n-1, sum) + numberSubset(arr, n-1, sum-arr[n-1]);
	}
	
	
	private static void printSubset(int[] arr, int n, int sum, String str, LinkedList l) 
	{
		// TODO Auto-generated method stub
		if(n==0 && sum!=0)
			 return;
		if(sum==0)
		{
			l.add(str);
			return;
		}
		
		printSubset(arr, n-1, sum, str, l) ;
		printSubset(arr, n-1, sum-arr[n-1], Integer.toString(arr[n-1])+" "+str, l);
	}

}
