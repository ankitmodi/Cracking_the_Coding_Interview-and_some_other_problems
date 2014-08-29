/* Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3]. */

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
    
    List mylist = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        
        if(root == null)
        {
            return mylist;
        }
        mylist.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return mylist;
        
    }
}
