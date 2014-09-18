/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" */


public class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        List<String> res = new ArrayList<String>();
        if(n <= 0)
        {
            return res;
        }
        generateParenthesisHelper(n, 0, 0, "", res);
        
        return res;
    }
    
    
    public void generateParenthesisHelper(int n, int left, int right, String tmp, List<String> res)
    {
        if(left==n)
        {
            for(int i=0; i<left-right; i++)
            {
                tmp += ")";
            }
            res.add(tmp);
            return;
        }
        
        if(left > right)
        {
            generateParenthesisHelper(n, left+1, right, tmp+"(", res);
            generateParenthesisHelper(n, left, right+1, tmp+")", res);
        }
        else
        {
            generateParenthesisHelper(n, left+1, right, tmp+"(", res);
        }
    }
}
