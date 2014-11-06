/*
 * The Pizzeria Problem
One pizza delivery boy has to serve "n" number of customers. He can serve one pizza at a time. 
Each customers pizza receiving time, and time taken to come back to the pizzeria are given. 
You have to find out maximum number of possible pizza deliveries.
Note :TIme taken by the delivery boy to customer is negligible

Input:
N : Number of customers
a[N] : Pizza receiving time
b[N] : Time needed to come back to pizzeria after delivering to ith customer
Output:
Maximum Number of orders that can be fulfilled using the scheduling you made

Ex :
Input : 5 {3 6 1 4 7} 
Input : 5 {5 8 4 7 10}
output: 3 (Explanation : a[2]->a[3]->a[4])

 */
public class Oracle2_Pizzeria 
{
	
	public static void main(String[] args) 
	{
		int[] a = {3, 6, 1, 4, 7};
		int[] b = {5, 8, 4, 7, 10};
		System.out.println(pizzeria(a,b));

	}
	public static int pizzeria(int[] a, int[] b)
	{
		int[] idx = new int[a.length];
		for(int i=0; i<idx.length; i++)
		{
			idx[i] = i;
		}
		//printMatrix(idx);
		
		/*
		printMatrix(idx);
		printMatrix(a);
		printMatrix(b);
		System.out.println();
		*/
		
		mergeSort(b,0,b.length-1, idx, a);
		
		/*
		printMatrix(idx);
		printMatrix(a);
		printMatrix(b);
		System.out.println();
		*/
		
		int count = 1;
		int lastEndTime = b[0];
		for(int i=1; i<b.length;i++)
		{
			if(a[i] >= lastEndTime)
			{
				count++;
				lastEndTime = b[i];
			}
		}
		
		return count;
	}
	
	
	
	public static void mergeSort(int[] a, int l, int r, int[] b, int[] c)
	{
		if(l<r)
		{
			int m = l + (r-l)/2;
			mergeSort(a, l, m, b, c);
			mergeSort(a, m+1, l, b, c);
			merge(a, l, m, r, b, c);
		}
	}
	
	
	
	public static void merge(int[] a, int l, int m, int r, int[] b, int[] c)
	{
		int n1 = m-l+1;
		int n2 = r-m;
		int[] L = new int[n1];
		int[] Lb = new int[n1];
		int[] Lc = new int[n1];
		
		int[] R = new int[n2];
		int[] Rb = new int[n2];
		int[] Rc = new int[n2];
		
		for(int i=0; i<n1; i++)
		{
			L[i] = a[l+i];
			Lb[i] = b[l+i];
			Lc[i] = c[l+i];
		}
		for(int i=0; i<n2; i++)
		{
			R[i] = a[m+1+i];
			Rb[i] = b[m+1+i];
			Rc[i] = c[m+1+i];
		}
		
		int i=0, j=0, k=l;
		while(i<n1 && j<n2)
		{
			if(L[i]<R[j])
			{
				a[k] = L[i];
				b[k] = Lb[i];
				c[k] = Lc[i];
				i++;
			}
			else
			{
				a[k] = R[j];
				b[k] = Rb[j];
				c[k] = Rc[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{	
			a[k] = L[i];
			b[k] = Lb[i];
			c[k] = Lc[i];
			i++;
			k++;
		}
		while(j<n2)
		{	
			a[k] = R[j];
			b[k] = Rb[j];
			c[k] = Rc[j];
			j++;
			k++;
		}
		
	}
	
	
	public static void printMatrix(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i] +" ");
		}
		System.out.println();
	}

}
