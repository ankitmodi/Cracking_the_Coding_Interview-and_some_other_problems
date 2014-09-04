/* Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. */



import java.util.*;
public class Solution 
{

    public List<List<Integer>> permute(int[] num) 
    {
        List nums = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++)
        {
            nums.add(num[i]);
        }
        List prefix = new ArrayList<Integer>();
        
        List res = new ArrayList<ArrayList<Integer>>();
        res = permutations(prefix, nums, res);
        return res;
    }
    
    public List<List<Integer>> permutations(List<Integer> prefix, List<Integer> nums, List<List<Integer>>res)
    {
        int n = nums.size();
        if(n==0)
        {
            res.add(prefix);
        }
        else
        {
            for(int i=0; i<n; i++)
            {
                List newPrefix = new ArrayList<Integer>();
                newPrefix.addAll(prefix);
                newPrefix.add(nums.get(i));
                
                List newNum = new ArrayList<Integer>();
                newNum.addAll(nums.subList(0,i));
                newNum.addAll(nums.subList(i+1, n));
                
                permutations(newPrefix, newNum, res);
            }
        }
        return res;
    }
}
