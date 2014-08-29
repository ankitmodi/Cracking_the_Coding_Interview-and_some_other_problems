/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1]. */

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
    List mylist = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        if(root == null)
        {
            return mylist;
        }
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        mylist.add(root.val);
        
        return mylist;
        
        
        
    }
}
