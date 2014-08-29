/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2]. */


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
    public List<Integer> inorderTraversal(TreeNode root)
    {
        
        if(root == null)
        {
            return mylist;
        }
        inorderTraversal(root.left);
        mylist.add(root.val);
        inorderTraversal(root.right);
        
        return mylist;
        
    }
}
