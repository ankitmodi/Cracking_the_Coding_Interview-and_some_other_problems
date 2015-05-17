public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int A) 
	{
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    
	    if(A==0)
	    {
	        return res;
	    }
	    
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    res.add(list);
	    
	    if(A==1)
	    {
	        return res;
	    }
	    
	    ArrayList<Integer> list2 = new ArrayList<Integer>();
	    list2.add(1);
	    list2.add(1);
	    res.add(list2);
	    
	    if(A==2)
	    {
	        return res;
	    }
	    
	    for(int i =3; i<=A; i++)
	    {
	        ArrayList<Integer> tmp = res.get(res.size()-1);
	        ArrayList<Integer> new_tmp = new ArrayList<Integer>();
	        new_tmp.add(1);
	        int size = tmp.size();
	        
	        for(int j = 1; j<size; j++)
	        {
	            new_tmp.add(tmp.get(j) + tmp.get(j-1));
	        }
	        new_tmp.add(1);
	        
	        
	        res.add(new_tmp);
	        
	    }
	    
	    return res;
	}
}
