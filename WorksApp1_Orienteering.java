package jp.co.worksap.global;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WorksApp1_Orienteering 
{

	//Helper class to ease out use of a cell in maze
	public static class Cell 
	{
	    public int row;     
	    public int col;
	    
	    public Cell(int row, int col)
	    {
	        this.row = row;
	        this.col = col;         
	    }
	    @Override
	    public String toString() {
	        return "{" + row + ", " + col + "}";
	    }

	   
	}
	
	public static void main(String[] args) throws IOException 
	{
		int result = orienteer();
		System.out.println(result);
	}
	
	
	public static int orienteer() throws IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimension = br.readLine().split(" ");
		
		int col = Integer.parseInt(dimension[0]);
		int row = Integer.parseInt(dimension[1]);
		
		//Create input matrix according to data given
		String[][] input = new String[row][col];
		for(int i=0; i<row; i++)
		{
			String colString = br.readLine();
			for(int j=0; j<col; j++)
			{
				input[i][j] = colString.substring(j,j+1);
			}
		}
		
		//Create a matrix showing which cells are visitable
		//0: visitable, 1:not visitable
		String[][] visitable = new String[input.length][input[0].length];
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(input[i][j].equals("#"))
				{
					visitable[i][j] = "1";
				}
				else
				{
					visitable[i][j] = "0";
				}
			}
		}
		//get the cell containing 'S' just after (-1,-1) i.e. the first starting cell
		Cell start = getStart(input);
		//if specifications don't match, return -1
		//i.e. if there are more than 1 "S" or 0 "G", return -1
		if(start==null || startCount(input)>1)
		{
			return -1;
		}
		
		//get the cell containing 'S' just after (-1,-1) i.e. the first Goal cell
		Cell goal = getGoal(input);
		//if specifications don't match, return -1
		//i.e. if there are more than 1 "G" or 0 "G", return -1
		if(goal==null || goalCount(input)>1)
		{
			return -1;
		}
		//get checkPoints cell
		Cell[] checkCells = getCheckCells(input);
		
		//array of cells to be visited
		Cell[] visit = new Cell[checkCells.length+2];
		visit[0] = start;
		for(int i=1; i<visit.length-1; i++)
		{
			visit[i] = checkCells[i-1];
		}
		visit[visit.length-1] = goal;
		
		//matrix to store shortest path from each member of cells to be visited i.e. visit[]
		//to each other member. shortestDist[i][j] = shortest path from cell visit[i] to cell visit[j]
		// n cross n
		//0->S,     1,2,...,n-2-> @,     n-1->G
		int[][] shortestDist = new int[visit.length][visit.length];
		for(int i=0; i<shortestDist.length; i++)
		{
			for(int j=0; j<shortestDist[0].length; j++)
			{
				if(i==j)
				{
					shortestDist[i][j] = 0;
				}
				
				else
				{
					Cell tmpStart = visit[i], tmpGoal = visit[j];
					Stack path = new Stack<>();
					shortestDist[i][j] = shortestPath(visitable, tmpStart, tmpGoal);
					//if specifications don't match, return -1
					//if the two must visit cells are not connected, 
					//then we can't traverse the maze as specified, so return -1
					//2147483647
					if(shortestDist[i][j] == Integer.MAX_VALUE)
					{
						return -1;
					}
				}
			}
		}
		
		return orienteerMinDist(shortestDist);
	}
	
	


	//return Start Cell
	public static Cell getStart(String[][] input)
	{
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(input[i][j].equals("S"))
				{
					return new Cell(i,j);
				}
			}
		}
		
		return null;
	}
	
	
	//return Goal Cell
	public static Cell getGoal(String[][] input)
	{
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(input[i][j].equals("G"))
				{
					return new Cell(i,j);
				}
			}
		}
		
		return null;
	}
	
	
	//returns array of cells having @
	public static Cell[] getCheckCells(String[][] mat)
	{
		ArrayList<Cell> list = new ArrayList<Cell>();
		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length; j++)
			{
				if(mat[i][j].equals("@"))
				{
					Cell p = new Cell(i,j);
					list.add(p);
				}
			}
		}
		Cell[] res = new Cell[list.size()];
		list.toArray(res);
		return res;
	}
	
	
	//returns number of "S" in input
	private static int startCount(String[][] input) 
	{
		int count = 0;
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(input[i][j].equals("S"))
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	
	//returns number of "G" in input
	private static int goalCount(String[][] input) 
	{
		int count = 0;
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(input[i][j].equals("G"))
				{
					count++;
				}
			}
		}
		
		return count;
	}

	
	
	//calculates minimum distance using the shortestDist matrix
	private static int orienteerMinDist(int[][] shortestDist) 
	{
		int n = shortestDist.length;
		//to keep track of which cells have been visited
		//0 ->S         1,2...,n-1 -> @
		//no need to keep track of G as it would be added in base case of helper method
		boolean[] isVisited = new boolean[n-1];
		isVisited[0] = true;
		return orienteerMinDistHelper(0, isVisited, shortestDist, 0, n);
	}


	//helper method for orienteerMinDist
	//recursively calls itself till each cell in isVisited has been visited
	private static int orienteerMinDistHelper(int source, boolean[] isVisited, int[][] shortestDist, 
											int pathLength, int n) 
	{
		//check if every cell other than G has been benefited
		if(allTrue(isVisited))
		{
			//n-1 -> G
			return pathLength + shortestDist[source][n-1];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<n-1; i++)
		{
			if(!isVisited[i])
			{
				isVisited[i] = true;
				int tmp = orienteerMinDistHelper(i, isVisited, shortestDist, pathLength + shortestDist[source][i], n);
				if(min > tmp)
				{
					min = tmp;
				}
				//back-tracking
				isVisited[i] = false;
			}
		}
		
		return min ;
	}


	//checks if every value in isVisited is true
	private static boolean allTrue(boolean[] isVisited) 
	{
		// TODO Auto-generated method stub
		for(int i=0; i<isVisited.length; i++)
		{
			if(!isVisited[i])
			{
				return false;
			}
		}
		return true;
	}
	
	
	//Calculates shortest path between start and end cell
		public static int shortestPath(String[][] map, Cell start, Cell end) 
		{
			map[start.row][start.col] = "s";
			map[end.row][end.col] = "e";
			// initialize distances array filled with MAX_VALUE
			int[][] distances = new int[map.length][];
			for (int i = 0; i < map.length; i++)
			{
				distances[i] = new int[map[i].length];
				Arrays.fill(distances[i], Integer.MAX_VALUE);
			}
			
			// distance of start node is made 0
			int distance = 0;
			List<Cell> currentCells = Arrays.asList(start);
			
			while (distances[end.row][end.col] == Integer.MAX_VALUE && !currentCells.isEmpty())
			{
				List<Cell> nextCells = new ArrayList<>();
				
				// set distances of previous round
				// and add their neighbors to list for next round
				for (Cell cell : currentCells) 
				{
					if (distances[cell.row][cell.col] == Integer.MAX_VALUE && !map[cell.row][cell.col].equals("1"))
					{
						distances[cell.row][cell.col] = distance;
						addNeighbors(cell, nextCells, map.length, map[0].length);
					}
				}
				
				//for the next round
				currentCells = nextCells;
				distance++;
			}
			
			map[start.row][start.col] = "0";
			map[end.row][end.col] = "0";
			return distances[end.row][end.col];
		}
		
		
		//helper method for shortest path
		private static void addNeighbors(Cell cell, List<Cell> list, int maxRow, int maxCol) 
		{
		    int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		    for (int[] d : ds) 
		    {
		        int row = cell.row + d[0];
		        int col = cell.col + d[1];          
		        if (isValid(row, col, maxRow, maxCol))
		            list.add(new Cell(row, col));
		    }
		}
		
		
		//helper method for addNeighbors
		//check if coordinates are inside the maze
		private static boolean isValid(int row, int col, int maxRow, int maxCol) 
		{
			return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
		}


}
