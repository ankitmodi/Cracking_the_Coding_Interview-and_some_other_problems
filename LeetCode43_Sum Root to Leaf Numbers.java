/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. */


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
    public int sumNumbers(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        ArrayList<String> myList = new ArrayList<String>();
        
        getStrings(root, myList, "");
        
        int res=0;
        for(String a : myList)
        {
            res += Integer.valueOf(a);
        }
        return res;
    }
    
    
    public void getStrings(TreeNode node, List<String> myList, String str)
    {
        if(node.left == null && node.right == null)
        {
            myList.add(str + String.valueOf(node.val));
            return;
        }
        if(node.left != null)
        {
            getStrings(node.left, myList, str + String.valueOf(node.val));
        }
        if(node.right != null)
        {
            getStrings(node.right, myList, str + String.valueOf(node.val));
        }

    }
}
