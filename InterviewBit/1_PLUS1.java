public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) 
	{
	    int size = A.size();
	    int carry = 0;
	    A.set(size-1, A.get(size-1)+1);
	    
	    int nonzero_index = 0;
	    for(nonzero_index=0; nonzero_index<size; nonzero_index++)
	    {
	        if(A.get(nonzero_index)!=0)
	        {
	            break;
	        }
	    }
	    
	    for(int i=size-1; i>=0; i--)
	    {
	        A.set(i, A.get(i)+carry);
	        if(A.get(i)==10)
	        {
	            A.set(i, 0);
	            carry = 1;
	        }
	        else
	        {
	            carry = 0;
	        }
	    }
	    ArrayList res = new ArrayList();
	    if(carry==1)
	    {
	        res.add(1);
	    }
	    
	    for(int i=nonzero_index; i<size; i++)
	    {
	        res.add(A.get(i));
	    }
	    
	    return res;
	}
}
