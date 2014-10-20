
/*Print matrix in spiral order*/

public class Epic1_Spiral_Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] arr = {{1, 2, 3, 4}, 
						{5, 6, 7, 8}, 
						{9, 10, 11, 12}};
		
		spiralOrder(arr);
		
		
		

	}
	
	public static void spiralOrder(int[][] arr)
	{
		int rowLow = 0, rowHigh = arr.length-1, colLow = 0, colHigh= arr[0].length-1;
		
		while(rowLow<=rowHigh && colLow<=colHigh)
		{
			//print uppermost row
			for(int i=colLow; i<=colHigh; i++)
			{
				System.out.print(arr[rowLow][i] + " ");
			}
			rowLow++;
			
			//print rightmost column
			for(int i=rowLow; i<=rowHigh; i++)
			{
				System.out.print(arr[i][colHigh] + " ");
			}
			colHigh--;
			
			//print lowermost row
			if(rowLow<=rowHigh)
			{
				for(int i=colHigh; i>=colLow; i--)
				{
					System.out.print(arr[rowHigh][i] + " ");
				}
				rowHigh--;
			}
			
			//print leftmost column
			if(colLow<=colHigh)
			{
				for(int i=rowHigh; i>=rowLow; i--)
				{
					System.out.print(arr[i][colLow] + " ");
				}
				colLow++;
			}
			
			
		}
	}
	

}
