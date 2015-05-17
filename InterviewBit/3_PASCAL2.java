public class Solution {
	public ArrayList<Integer> getRow(int A) 
	{
	    ArrayList<Integer> list1 = new ArrayList<Integer>();
	    
	    if(A<0)
	    {
	        return list1;
	    }
	    
	    list1.add(1);
	    
	    if(A==0)
	    {
	        return list1;
	    }
	    
	    ArrayList<Integer> list2 = new ArrayList<Integer>();
	    list2.add(1);
	    list2.add(1);
	    
	    if(A==1)
	    {
	        return list2;
	    }
	    
	    for(int i=2; i<=A; i++)
	    {
	        list1 = list2;
	        list2 = new ArrayList<Integer>();
	        list2.add(1);
	        int size = list1.size();
	        
	        for(int j = 1; j<size; j++)
	        {
	            list2.add(list1.get(j) + list1.get(j-1));
	        }
	        list2.add(1);
	        
	    }
	    
	    return list2;
	    
	}
}
