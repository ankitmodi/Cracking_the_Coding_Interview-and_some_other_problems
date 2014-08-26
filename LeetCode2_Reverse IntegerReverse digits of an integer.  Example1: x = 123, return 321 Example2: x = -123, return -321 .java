/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
*/

public class Solution
{
    public int reverse(int x)
    {
        
        String str = String.valueOf(x);
        if(x<0)
        {
            String str1 = str.substring(1);
            StringBuffer buff = new StringBuffer(str1);
            String result= buff.reverse().toString();
            Integer y = Integer.valueOf(result);
            return -1*y;
        }
        else
        {
            StringBuffer buff = new StringBuffer(str);
            String result= buff.reverse().toString();
            Integer y = Integer.valueOf(result);
            return y;
        }
            
        
        
    }
}
