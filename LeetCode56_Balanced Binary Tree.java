/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. */

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
    public boolean isBalanced(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }
        if(isBalancedHeight(root)==-1)
        {
            return false;
        }
        
        return true;
        
    }
    
    
    public int isBalancedHeight(TreeNode node) 
    {
        if(node == null)
        {
            return 0;
        }
        
        
        int lh = isBalancedHeight(node.left);
        int rh = isBalancedHeight(node.right);
        
        if(lh==-1 || rh==-1)
        {
            return -1;
        }
        
        if(Math.abs(lh-rh) > 1)
        {
            return -1;
        }
        
        return 1 + Math.max(lh, rh);
    }
    
}
