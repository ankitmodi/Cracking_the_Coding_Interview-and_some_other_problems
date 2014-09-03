/*Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? */



public class Solution 
{
    public List<Integer> getRow(int index)
    {
        int numRows = index + 1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return res.get(0);
        }
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        
        res.add(l1);
        if(numRows==1)
        {
            return res.get(0);
        }
        
        
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(1);
        
        res.add(l2);
        if(numRows==2)
        {
            return res.get(1);
        }
        
        for(int i=3; i<=numRows; i++)
        {
            List<Integer> tmp = res.get(i-2);
            List<Integer> newlist = new ArrayList<Integer>();
            //we need i-1 but index starts from 0, so i-2
            for(int j=1; j<=i; j++)
            {
                if(j==1)
                {
                    newlist.add(tmp.get(j-1));
                }
                else if(j==i)
                {
                    newlist.add(tmp.get(j-2));
                }
                else
                {
                    newlist.add(tmp.get(j-2) + tmp.get(j-1));
                }
            }
            res.add(newlist);
        }
        
        return res.get(index);
    }
}
