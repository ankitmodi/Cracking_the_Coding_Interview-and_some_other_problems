/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }
        
        return isSymmetricHelper(root.left, root.right);
    }
    
    
    public boolean isSymmetricHelper(TreeNode l, TreeNode r)
    {
        if(l==null || r==null)
        {
            return l==r;
        }
        
        return l.val == r.val && isSymmetricHelper(l.left, r.right) && isSymmetricHelper(l.right, r.left);
    }
}
