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
	        ArrayList<Integer> tmp = list2;
	        ArrayList<Integer> new_tmp = new ArrayList<Integer>();
	        new_tmp.add(1);
	        int size = tmp.size();
	        
	        for(int j = 1; j<size; j++)
	        {
	            new_tmp.add(tmp.get(j) + tmp.get(j-1));
	        }
	        new_tmp.add(1);
	        
	        
	        list2 = new_tmp;
	        
	    }
	    
	    return list2;
	    
	}
}
