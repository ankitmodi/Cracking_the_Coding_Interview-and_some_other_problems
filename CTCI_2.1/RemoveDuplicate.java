//Remove duplicates from an unsorted linked list

import java.util.*;
public class RemoveDuplicate {
	
	
	
	public static void removeDuplicate(LinkedList myList)
	{
		int size = myList.size();
		boolean[] index = new boolean[size];
		
		int i, checker = 0;
		
		for(i=0; i<size; i++)
		{
			int val = (Integer) myList.get(i);
			if((checker & (1 << val)) > 0)
			{
				index[i] = true;
			}
			else
			{
				checker |= 1 << val;
			}
		}
		
		int count=0;
		for(i=0; i<size; i++)
		{
			if(index[i])
			{
				myList.remove(i-count);
				count++;
			}
		}
	}
	
	public static void main(String args[])
	{
		LinkedList sll = new LinkedList();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(4);
		sll.add(5);
		sll.add(6);
		sll.add(1);
		sll.add(2);
		sll.add(7);
		
		System.out.println(sll);
		System.out.println("size: " + sll.size());
		removeDuplicate(sll);
		System.out.println(sll);
		System.out.println("size: " + sll.size());
	}

}
