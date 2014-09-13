/* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
        {
            return res;
        }
        
        pathSumHelper(root, sum, res, "");
        return res;
    }
    
    
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, String m) 
    {
        
        if(root.left==null && root.right!=null)
        {
            pathSumHelper(root.right, sum-root.val, res, m+String.valueOf(root.val)+" ");
        }
        else if(root.left!=null && root.right==null)
        {
            pathSumHelper(root.left, sum-root.val, res, m+String.valueOf(root.val)+" ");
        }
        else if(root.left!=null && root.right!=null)
        {
            pathSumHelper(root.left, sum-root.val, res, m+String.valueOf(root.val)+" ");
            pathSumHelper(root.right, sum-root.val, res, m+String.valueOf(root.val)+" ");
        }
        
        else
        {
            if(sum == root.val)
            {
                m += String.valueOf(root.val)+" ";
                m = m.trim();
                String[] parts = m.split(" ");
                List a = new ArrayList<Integer>();
                for(int i=0; i<parts.length; i++)
                {
                    a.add(Integer.valueOf(parts[i]));
                }
                res.add(a);
            }
        }
    }
}
