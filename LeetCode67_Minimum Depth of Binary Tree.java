/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        return minDepthHelper(root);
        
    }
    
    public int minDepthHelper(TreeNode root) 
    {
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        else if(root.left!=null && root.right==null)
        {
            return 1 + minDepthHelper(root.left);
        }
        else if(root.left==null && root.right!=null)
        {
            return 1 + minDepthHelper(root.right);
        }
        else
        {
            return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
        }
        
    }
}
