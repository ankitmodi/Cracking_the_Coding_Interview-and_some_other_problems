/*
The longest Increasing Subsequence (LIS) problem is to find the length of the 
longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
*/


import java.util.*;
public class DP1_LIS 
{
	public static void main(String args[])
	{
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; 
		
		System.out.println("Longest increasing subsequence is: " + LIS(arr));
	}
	
	public static int LIS(int[] arr)
	{
		int n= arr.length;
		if(n==0 || n==1)
		{
			return n;
		}
		
		int[] res = new int[n];
		Arrays.fill(res,1);
		
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[i] > arr[j] && res[i] < res[j] + 1)
				{
					res[i] = res[j] + 1;
				}
			}
		}
		int max = res[0];
		for(int i=0; i<res.length; i++)
		{
			if(max < res[i])
				max = res[i];
		}
		
		return max;
	}
}
