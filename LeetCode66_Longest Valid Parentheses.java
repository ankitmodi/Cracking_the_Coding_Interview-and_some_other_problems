/*Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. */


public class Solution 
{
    public int longestValidParentheses(String s) 
    {
        int len = s.length(), res = 0;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<len; i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(i);
            }
            else
            {
                if(st.empty())
                {
                    st.push(i);
                }
                else
                {
                    if(s.charAt(st.peek()) == '(')
                    {
                        st.pop();
                    }
                    else
                    {
                        st.push(i);
                    }
                }
            }
        }
        if(st.empty())
        {
            res = len;
        }
        
        else
        {
            int a =len, b =0;
            while(!st.empty())
            {
                b= st.pop();
                res = Math.max(res, a-b-1);
                a = b;
            }
            res = Math.max(res, a);
            //res = Math.max(res, a+1-1);
            //where b is -1
        }
        
        return res;
        
    }
}
