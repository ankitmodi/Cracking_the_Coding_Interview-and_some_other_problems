/*Given a linked list of integers, remove all duplicates.*/

import java.util.*;
public class RemoveDupFromLL 
{
	public static void main(String args[])
	{
		LinkedList l = new LinkedList();
		l.add(12);
		l.add(11);
		l.add(12);
		l.add(21);
		l.add(21);
		l.add(41);
		l.add(43);
		l.add(21);
		l.add(21);
		
		printList(l);
		
		removeDuplicates(l);
		
		printList(l);
	}
	
	private static void removeDuplicates(LinkedList l)
	{
		HashMap hm = new HashMap();
		LinkedList deleteList = new LinkedList();
		
		int size = l.size();
		if(size<=1)
			return ;
		hm.put(l.get(0), 1);
		
		for(int i=1; i<size; i++)
		{
			Object key = l.get(i);
			if(hm.containsKey(key))
			{
				deleteList.add(key);
			}
			else
			{
				hm.put(key, 1);
			}
		}
		
		int deleteListSize = deleteList.size();
		for(int i=0; i<deleteListSize; i++)
		{
			l.remove(deleteList.get(i));
		}
		
		
		
	}

	private static void printMap(HashMap hm) 
	{
		//Set set = hm.entrySet();
		Iterator i = hm.entrySet().iterator();
		
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next();
			System.out.println(me.getKey() + ":  " + me.getValue());
		}
		
	}

	public static void printList(LinkedList l)
	{
		int size = l.size();
		for(int i=0; i<size; i++)
		{
			System.out.print(l.get(i) + " ");
		}
		System.out.println();
	}
	
	

}
