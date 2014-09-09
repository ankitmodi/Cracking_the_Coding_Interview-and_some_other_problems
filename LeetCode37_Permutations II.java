/* Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. */


import java.util.*;
public class Solution 
{

    public List<List<Integer>> permuteUnique(int[] num) 
    {
        List nums = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++)
        {
            nums.add(num[i]);
        }
        List prefix = new ArrayList<Integer>();
        List results = new ArrayList<ArrayList<Integer>>();
        
        Set res = new HashSet<ArrayList<Integer>>();
        res = permutations(prefix, nums, res);
        results.addAll(res);
        return results;
    }
    
    public Set<List<Integer>> permutations(List<Integer> prefix, List<Integer> nums, Set<List<Integer>> res)
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
