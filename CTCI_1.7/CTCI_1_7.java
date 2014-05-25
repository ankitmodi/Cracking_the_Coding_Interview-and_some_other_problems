//  Write an algorithm such that if an element in an M by N matrix is 0, 
//  its entire row and column are set to 0.

import java.util.*;
import java.io.*;
public class CTCI_1_7 
{
	public static void main (String args[]) throws IOException
	{
		int M, N, i,j, count =0;
		
		//path to your input file
		BufferedReader reader = new BufferedReader(new FileReader("path/input.txt"));
		
		String line = reader.readLine();
		String[] parts = line.split(" ");
		
		M = Integer.parseInt(parts[0]);
		N = Integer.parseInt(parts[1]);
		
		int[][] myArr = new int[M][N];
		
		while((line = reader.readLine()) != null){
			parts = line.split(" ");
			for(i=0;i<N;i++)
			{
				myArr[count][i] = Integer.parseInt(parts[i]);
			}
			count++;
		}
		
		//printArray(myArr);
		
		int[][] outputArr = new int[M][N];
		outputArr = setZero(myArr);
		
		printArray(outputArr);
	}
	
	
	
	public static int[][] setZero(int[][] inputArr)
	{
		int row = inputArr.length;
		int col = inputArr[0].length;
		
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		for(int i =0; i<row; i++)
		{
			for(int j =0; j<col; j++)
			{
				if(inputArr[i][j] == 0)
				{
					r.add(i);
					c.add(j);
				}
			}
		}
		int size = r.size();
		for(int i=0; i<size; i++)
		{
			int tmp_r = r.get(i);
			int tmp_c = c.get(i);
			
			for(int j=0; j<col; j++)
			{
				inputArr[tmp_r][j] = 0;
			}
			for(int j=0; j<row; j++)
			{
				inputArr[j][tmp_c] = 0;
			}
		}
		
		
		return inputArr;
	}
	
	
	
	public static void printArray(int[][] inputArr) throws IOException
	{
		int row = inputArr.length;
		int col = inputArr[0].length;
		
		//path to your output file
		File file = new File("path/output.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				sb.append(inputArr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		writer.write(sb.toString());
		writer.close();
		//System.out.println("done");
	}
	
	
}
	
