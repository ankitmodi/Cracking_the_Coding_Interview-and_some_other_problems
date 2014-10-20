import java .util.*;
public class Sort
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {5 , 10, 15, 0, 25, 4 , 11, 5};
		//int[] arr = { 0, 25, 4 , 11};
		print(arr);
		//swap(arr, 0, 1);
		//print(arr);
		//bubble_sort(arr);
		mergesort(arr, 0, arr.length-1);
		print(arr);

	}
	
	public static void mergesort(int[] arr, int l, int r)
	{
		if(l<r)
		{
			int m= l + (r-l)/2;
			mergesort(arr, l, m);
			mergesort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int r)
	{
		int n1 = m-l+1;
		int n2 = r-m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0; i<n1; i++)
		{
			L[i] = arr[l+i];
		}
		for(int j=0; j<n2; j++)
		{
			R[j] = arr[m+1+j];
		}
		
		int i=0, j=0, k=l;
		while(i<n1 && j<n2)
		{
			if(L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void print(int[] arr)
	{
		for(int i: arr)
		{
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public static void bubble_sort(int arr[])
	{
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=0; j<arr.length-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int m, int n)
	{
		arr[m] = arr[m] ^ arr[n];
		arr[n] = arr[m] ^ arr[n];
		arr[m] = arr[m] ^ arr[n];
	}

}
