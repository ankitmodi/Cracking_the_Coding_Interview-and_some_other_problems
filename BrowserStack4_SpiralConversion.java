/*
 * Question: You join a company which uses a legacy command line program. 
 * This program when given an input like this: a b c d e f g h i
Spits out an output like this:   a b c f  i h g d e

Source code of this program is long lost and only the binary remains. 
You manager has asked you determine the logic and write this program, in a computer language 
that you prefer, so that source code of the program is in the control of the company.
Sample Input (Plaintext Link)
a b c
d e f
g 19 20
Sample Output (Plaintext Link)
a b c f 20 19 g d e

 */
import java.util.*;
public class BrowserStack4_SpiralConversion 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String str = "a b c d e f g h i";
		//System.out.println(str.length()+str);
		str = removeSpaces(str);
		//System.out.println(str);
	
		String strOut = "a b c f i h g d e";
		strOut = removeSpaces(strOut);
		
		System.out.println("Source Code's output:");
		System.out.println(SpiralConversion(str, strOut));

	}

	
	
	private static String removeSpaces(String str) 
	{
		int len = str.length();
		String res = "";
		for(int i=0; i<len; i++)
		{
			String tmp = str.substring(i,i+1);
			if(!tmp.equals(" "))
			{
				res += tmp;
			}
		}
		// TODO Auto-generated method stub
		return res;
	}

	
	
	private static String SpiralConversion(String str, String strOut) 
	{
		int len = str.length();
		//System.out.println(str);
		//System.out.println(strOut);
		int col = 0;
		while(str.charAt(col) == strOut.charAt(col))
		{
			col++;
		}
		
		int row = len/col;
		//System.out.println(col + "  " + row);
		char[][] mat = new char[row][col];
		
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				mat[i][j] = str.charAt(i*col + j);
			}
		}
		//printMatrix(mat);
		
		int rowMax=row-1, rowMin =0, colMax = col-1, colMin = 0;
		String res = "";
		
		while(rowMax>=rowMin && colMax>=colMin)
		{
			for(int i=colMin; i<=colMax; i++)
			{
				res += mat[rowMin][i] + " ";
			}
			rowMin++;
			
			for(int i=rowMin; i<=rowMax; i++)
			{
				res += mat[i][colMax] + " ";
			}
			colMax--;
			
			if(rowMax>=rowMin)
			{
				for(int i=colMax; i>=colMin; i--)
				{
					res += mat[rowMax][i] + " ";
				}
				rowMax--;
			}
			
			if(colMax>=colMin)
			{
				for(int i=rowMax; i>=rowMin; i--)
				{
					res += mat[i][colMin] + " ";
				}
				colMin++;
			}
		}
		
		return res;
	}
	
	private static void printMatrix(char[][] mat)
	{
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
