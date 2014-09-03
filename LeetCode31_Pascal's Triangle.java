/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return res;
        }
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        
        res.add(l1);
        if(numRows==1)
        {
            return res;
        }
        
        
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(1);
        
        res.add(l2);
        if(numRows==0)
        {
            return res;
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
        
        return res;
    }
}
