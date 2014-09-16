/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null)
        {
            return res;
        }
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root);
        
        while(!q1.isEmpty())
        {
            List<Integer> mylist1 = new ArrayList<Integer>();
            while(!q1.isEmpty())
            {
                TreeNode temp = q1.poll();
                mylist1.add(temp.val);
                
                if(temp.left!=null)
                {
                    q2.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q2.offer(temp.right);
                }
            }
            if(!mylist1.isEmpty())
            {
                res.add(mylist1);
            }
            
            
            List<Integer> mylist2 = new ArrayList<Integer>();
            while(!q2.isEmpty())
            {
                TreeNode temp = q2.poll();
                mylist2.add(temp.val);
                
                if(temp.left!=null)
                {
                    q1.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q1.offer(temp.right);
                }
            }
            if(!mylist2.isEmpty())
            {
                res.add(mylist2);
            }
            
            
        }
        
        return res;
    }
}
